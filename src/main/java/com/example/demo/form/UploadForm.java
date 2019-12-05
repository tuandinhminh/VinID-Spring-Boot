package com.example.demo.form;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {
    private MultipartFile fileData;

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }
}
