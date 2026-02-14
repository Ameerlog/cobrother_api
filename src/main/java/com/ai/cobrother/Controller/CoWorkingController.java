package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.CoWorking;
import com.ai.cobrother.Service.CoWorkingService;
import com.ai.cobrother.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CoWorkingController {

    public final CoWorkingService service;
    private final FileService fileService;


    @Autowired
    public CoWorkingController(CoWorkingService service,
                               FileService fileService) {
        this.service = service;
        this.fileService = fileService;
    }

//    @PostMapping("/CreateCoworking")
//    public CoWorking CreateCoWorking(@RequestBody CoWorking cowork){
//        return service.createCoWorking(cowork);
//    }




    @PostMapping(value = "/CreateCoworking", consumes = "multipart/form-data")
    public CoWorking CreateCoWorking(
            @RequestPart("data") String data,
            @RequestPart("logo") MultipartFile logo
    ) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        CoWorking coworking = mapper.readValue(data, CoWorking.class);

        String logoUrl = fileService.uploadFile(logo);

        coworking.setLogo(logoUrl);

        return service.createCoWorking(coworking);
    }
    @GetMapping("/ListAllCoWorking")
    public List<CoWorking> getAllCoWorking(){
        return service.getAllCoWorking();
    }
}
