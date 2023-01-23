package com.lms.university.LearningManagementSystem.controler;

import java.io.IOException;

import com.lms.university.LearningManagementSystem.service.impl.ProductImageServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("api/v1/image")
@CrossOrigin("http://localhost:3000")
public class ProductImageController {

    @Autowired
    private ProductImageServiceIMPL productImageService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("productImage")MultipartFile file) throws IOException{
        productImageService.uploadImage(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
        byte[] image = productImageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
