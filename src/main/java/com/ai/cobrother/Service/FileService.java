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
//    @Value("${file.upload-dir}")
//    private String uploadDir;
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
////        return "http://localhost:8080/uploads/" + fileName;
//        return "http://cobrother-api.onrender.com/tmp/uploads/" + fileName;
//
//    }
//}








package com.ai.cobrother.Service;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations gridFsOperations;

    /**
     * Upload file to MongoDB GridFS
     * @param file - MultipartFile from form upload
     * @return fileId - MongoDB ObjectId as String
     */
    public String uploadFile(MultipartFile file) throws IOException {

        // Store file in GridFS
        ObjectId fileId = gridFsTemplate.store(
                file.getInputStream(),
                file.getOriginalFilename(),
                file.getContentType()
        );

        // Return the fileId (this will be stored in MongoD B as logoUrl)
        return fileId.toString();
    }

    /**
     * Get file from GridFS by fileId
     * @param fileId - MongoDB ObjectId as String
     * @return GridFSFile object
     */
    public GridFSFile getFile(String fileId) {
        return gridFsOperations.findOne(
                new Query(Criteria.where("_id").is(fileId))
        );
    }
}