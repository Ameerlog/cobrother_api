package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.CoWorking;
import com.ai.cobrother.Model.Domain;
import com.ai.cobrother.Service.DomainService;
import com.ai.cobrother.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class DomainController {
//
//    public final DomainService domainService;
//
//    @Autowired
//    public DomainController(DomainService domainService) {
//        this.domainService = domainService;
//    }
//
//    @PostMapping("/createDomain")
//    public Domain CreateDomain(@RequestBody Domain domain){
//        return domainService.CreateDomains(domain);
//    }
//
//
//    @GetMapping("/ListAllDomains")
//    public List<Domain> getAllDomains(){
//        return domainService.getAllDomains();
//    }
//}



@RestController
@RequestMapping("/api")
@CrossOrigin
public class DomainController {

    private final DomainService domainService;
    private final FileService fileService;

    @Autowired
    public DomainController(DomainService domainService,
                            FileService fileService) {
        this.domainService = domainService;
        this.fileService = fileService;
    }

    @PostMapping(value = "/createDomain", consumes = "multipart/form-data")
    public Domain createDomain(
            @RequestPart("data") String data,
            @RequestPart("logo") MultipartFile logo
    ) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Domain domain = mapper.readValue(data, Domain.class);

        String logoUrl = fileService.uploadFile(logo);

        domain.setLogo(logoUrl);

        return domainService.CreateDomains(domain);
    }

    @GetMapping("/ListAllDomains")
    public List<Domain> getAllDomains(){
        return domainService.getAllDomains();
    }




    @GetMapping("/domain/{id}")
    public Domain getDomainById(@PathVariable String id){
        return domainService.getDomainById(id);
    }
    }



