<<<<<<< HEAD
////package com.ai.cobrother.Service;
////
////import org.springframework.stereotype.Service;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.io.File;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////import java.util.UUID;
////
////@Service
////public class FileService {
////
////    private final String uploadDir = "uploads/";
////
////    public String uploadFile(MultipartFile file) throws Exception {
////
////        File dir = new File(uploadDir);
////        if (!dir.exists()) {
////            dir.mkdirs();
////        }
////
////        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
////        Path filePath = Paths.get(uploadDir, fileName);
////
////        Files.copy(file.getInputStream(), filePath);
////
////        return "http://localhost:8080/uploads/" + fileName;
////    }
////}
//
//
//
//
//
//package com.ai.cobrother.Service;
//
//import org.springframework.beans.factory.annotation.Value;
=======
//package com.ai.cobrother.Service;
//
>>>>>>> 56bc0171d34b56618772ca2e1dfd6d39f3b41083
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.UUID;
//
//@Service
//public class FileService {
//
//    private final String uploadDir = "uploads/";
//
//    public String uploadFile(MultipartFile file) throws Exception {
//
//        File dir = new File(uploadDir);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//
//        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
//        Path filePath = Paths.get(uploadDir, fileName);
//
//        Files.copy(file.getInputStream(), filePath);
//
//        return "http://localhost:8080/uploads/" + fileName;
//    }
//}





package com.ai.cobrother.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String uploadFile(MultipartFile file) throws Exception {

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);

        Files.copy(file.getInputStream(), filePath);

//        return "http://localhost:8080/uploads/" + fileName;
        return "http://192.168.29.184:8080/uploads/" + fileName;
    }
}
