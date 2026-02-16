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

    /**
     * Endpoint to serve images from GridFS
     * Example: GET /api/images/{fileId}
     */
    @GetMapping("/{fileId}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileId) throws IOException {

        // Get file from GridFS
        GridFSFile gridFSFile = fileService.getFile(fileId);

        if (gridFSFile == null) {
            return ResponseEntity.notFound().build();
        }

        // Get file resource
        GridFsResource resource = gridFsOperations.getResource(gridFSFile);

        // Get file content type (image/png, image/jpeg, etc.)
        String contentType = gridFSFile.getMetadata() != null
                ? gridFSFile.getMetadata().get("_contentType").toString()
                : "application/octet-stream";

        // Convert to byte array
        byte[] data = IOUtils.toByteArray(resource.getInputStream());

        // Return image with proper content type
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(data);
    }
}