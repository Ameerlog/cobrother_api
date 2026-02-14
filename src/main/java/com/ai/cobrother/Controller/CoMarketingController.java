package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.CoCreation;
import com.ai.cobrother.Model.CoMarketing;
import com.ai.cobrother.Service.CoMarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CoMarketingController {

    public final CoMarketingService service;

    @Autowired
    public CoMarketingController(CoMarketingService service) {
        this.service = service;
    }

    @PostMapping("/CreateCoMarketing")
    public CoMarketing CreateCoMarketing(@RequestBody CoMarketing comarket){
        return service.CreateCoMarketing(comarket);
    }
    @GetMapping("/ListAllCoMarketing")
    public List<CoMarketing> getAllCoMarketing(){
        return service.getAllCoMarketing();
    }
}
