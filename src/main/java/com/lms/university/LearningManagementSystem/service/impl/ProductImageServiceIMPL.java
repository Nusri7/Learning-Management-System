package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.entity.ProductImage;
import com.lms.university.LearningManagementSystem.repository.ProjectImageRepo;
import com.lms.university.LearningManagementSystem.utill.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProductImageServiceIMPL {
    @Autowired
    private ProjectImageRepo imageRepo;

    public ProductImage uploadImage(MultipartFile file) throws IOException {
        ProductImage pImage = new ProductImage();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        return imageRepo.save(pImage);
    }

    public byte[] downloadImage(String fileName){
        Optional<ProductImage> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
}

