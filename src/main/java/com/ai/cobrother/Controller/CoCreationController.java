package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.CoBranding;
import com.ai.cobrother.Model.CoCreation;
import com.ai.cobrother.Service.CoCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CoCreationController {

    public final CoCreationService service;

    @Autowired
    public CoCreationController(CoCreationService service) {
        this.service = service;
    }

    @PostMapping("/createCoCreation")
    public CoCreation createCoCreation(@RequestBody CoCreation cocreate){
        return service.CreateCoCreation(cocreate);
    }
    @GetMapping("/ListAllCoCreation")
    public List<CoCreation> getAllCoCreation(){
        return service.getAllCoCreation();
    }
}
