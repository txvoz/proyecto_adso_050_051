package edu.co.sena.apiclient.controllers;

import edu.co.sena.apiclient.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/file")
public class UploadController {
    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file ) {

        String fileName = Math.random()*10000 + "-" + file.getOriginalFilename();
        try {
            String basePathToUpload = Constants.PATH_UPLOAD;
            String newPath =  basePathToUpload + fileName;
            System.out.println("Aquiii >> " + newPath);
            file.transferTo( new File(newPath));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(fileName);
    }

}

//https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/file-upload-Spring-Boot-Ajax-example