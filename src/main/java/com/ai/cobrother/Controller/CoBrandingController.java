package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.CoVenture;
import com.ai.cobrother.Service.CoBrandingService;
import com.ai.cobrother.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class CoBrandingController {
//
//    public final CoBrandingService service;
//
//    @Autowired
//    public CoBrandingController(CoBrandingService service) {
//        this.service = service;
//    }
//
//    @PostMapping("/createCoBranding")
//    public CoBranding CreateCoBranding(@RequestBody CoBranding coBrand){
//        return service.CreateCoBranding(coBrand);
//    }
//
//    @GetMapping("/ListAllBrands")
//    public List<CoBranding> getAllBrands(){
//        return service.getAllBrands();
//    }
//
//
//}








@RestController
@RequestMapping("/api")

public class CoBrandingController {

    private final CoBrandingService service;
    private final FileService fileService;

    @Autowired
    public CoBrandingController(CoBrandingService service,
                                FileService fileService) {
        this.service = service;
        this.fileService = fileService;
    }

    @PostMapping(value = "/createCoVenture",
            consumes = "multipart/form-data")
    public CoVenture createCoBranding(
            @RequestPart("data") String data,
            @RequestPart("logo") MultipartFile logo
    ) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        CoVenture coBrand = mapper.readValue(data, CoVenture.class);

        System.out.println("BrandDetails: " + coBrand.getBrandDetails());

        String logoUrl = fileService.uploadFile(logo);

        coBrand.getBrandDetails().setLogoUrl(logoUrl);

        return service.CreateCoBranding(coBrand);
    }

    @GetMapping("/ListAllBrands")
    public List<CoVenture> getAllBrands(){
        return service.getAllBrands();
    }
}
