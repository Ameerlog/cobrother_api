//package com.ai.cobrother.Controller;
//
//import com.ai.cobrother.Model.Venture;
//import com.ai.cobrother.Service.JointVentureService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//
//public class JointVentureController {
//
//    public final JointVentureService service;
//
//    @Autowired
//    public JointVentureController(JointVentureService service) {
//        this.service = service;
//    }
//
//
//    @PostMapping("/CreateJointVenture")
//    public Venture CreateJointVenture(@RequestBody Venture jv){
//        return service.createJointVenture(jv);
//    }
//}


//package com.ai.cobrother.Controller;
//
//import com.ai.cobrother.Model.Venture;
//import com.ai.cobrother.Service.FileService;
//import com.ai.cobrother.Service.JointVentureService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import tools.jackson.databind.ObjectMapper;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//
//public class JointVentureController {
//
//    private final JointVentureService service;
//    private final FileService fileService;
//
//    @Autowired
//    public JointVentureController(JointVentureService service,
//                                  FileService fileService) {
//        this.service = service;
//        this.fileService = fileService;
//    }
//
//    // CREATE JV WITH LOGO UPLOAD (GridFS)
//    @PostMapping(value = "/createJointVenture", consumes = "multipart/form-data")
//    public Venture createJointVenture(
//            @RequestPart("data") String data,
//            @RequestPart("logo") MultipartFile logo
//    ) throws Exception {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        Venture venture = mapper.readValue(data, Venture.class);
//
//        System.out.println("Venture Name: " + venture.getFullName());
//
//        String logoUrl = fileService.uploadFile(logo);
//
//        venture.setLogoUrl(logoUrl);
//
//        return service.createJointVenture(venture);
//    }
//
//    // GET ALL JV
//    @GetMapping("/listAllVentures")
//    public List<Venture> getAllVentures(){
//        return service.getAllVentures();
//    }
//}


package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.Venture;
import com.ai.cobrother.Service.FileService;
import com.ai.cobrother.Service.JointVentureService;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JointVentureController {

    private final JointVentureService service;
    private final FileService fileService;

    @Autowired
    public JointVentureController(JointVentureService service,
                                  FileService fileService) {
        this.service = service;
        this.fileService = fileService;
    }

    @PostMapping(value = "/createJointVenture", consumes = "multipart/form-data")
    public Venture createJointVenture(
            @RequestPart("data") String data,
            @RequestPart("logo") MultipartFile logo
    ) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Venture venture = mapper.readValue(data, Venture.class);

        System.out.println("Venture Name: " + venture.getFullName());

        String logoUrl = fileService.uploadFile(logo);

        return service.createJointVenture(venture);
    }

    @GetMapping("/listAllVentures")
    public List<Venture> getAllVentures() {
        return service.getAllVentures();
    }
}