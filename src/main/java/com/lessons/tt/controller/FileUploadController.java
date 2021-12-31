package com.lessons.tt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    /**
     * MultipartFile is used for sending and recieving files
     */
    public String fileUpload(@RequestParam MultipartFile file) throws IOException {
        File uploadedFile = new File("D:\\"+file.getOriginalFilename());
        uploadedFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(uploadedFile);
        fout.write(file.getBytes());
        fout.close();
        return "File Uploaded Successfully";
    }
}
