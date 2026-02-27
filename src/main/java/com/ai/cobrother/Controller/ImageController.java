package com.ai.cobrother.Controller;

import com.ai.cobrother.Service.FileService;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private FileService fileService;

    @Autowired
    private GridFsOperations gridFsOperations;

    @GetMapping("/{fileId}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileId) throws IOException {
        GridFSFile gridFSFile = fileService.getFile(fileId);
        if (gridFSFile == null) {
            return ResponseEntity.notFound().build();
        }
        GridFsResource resource = gridFsOperations.getResource(gridFSFile);
        String contentType = gridFSFile.getMetadata() != null
                ? gridFSFile.getMetadata().get("_contentType").toString()
                : "application/octet-stream";
        byte[] data = IOUtils.toByteArray(resource.getInputStream());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(data);
    }
}