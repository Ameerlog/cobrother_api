package com.ai.cobrother.Service;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Value("${app.base-url:https://cobrother-api.onrender.com}")
    private String uploadedFileBaseUrl;

    public String uploadFile(MultipartFile file) throws Exception {
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.copy(file.getInputStream(), filePath);
        return uploadedFileBaseUrl + "/uploads/" + fileName;
    }

    public GridFSFile getFile(String fileId) {
        return gridFsTemplate.findOne(
            new Query(Criteria.where("_id").is(fileId))
        );
    }
}