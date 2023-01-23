package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.service.impl.FileServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("api/v1/file")
@CrossOrigin("http://localhost:3000")
public class FileController {

    @Autowired
    FileServiceIMPL fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {
        try {
            fileService.uploadFile(uploadfile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam("filename") String filename) {

        Resource resource = null;
        try {
            resource = fileService.downloadFile(filename);
            String contentType = "application/octet-stream";

            return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
