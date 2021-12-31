package com.lessons.tt.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class FileDownloadController {

    @GetMapping("/download")
    /**
     * Allow CORS per API
     */
    //@CrossOrigin(origins = "http://localhost:9090")
    public ResponseEntity<Object> downloadFile() throws IOException {
        String fileName = "D:\\data.txt";
        File outFile = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(outFile));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", outFile.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(
                outFile.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;

    }
}
