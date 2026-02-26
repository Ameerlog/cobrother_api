package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.CoMarketing;
import com.ai.cobrother.Model.CoOperation;
import com.ai.cobrother.Service.CoOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CoOperationController {

    public final CoOperationService service;

    @Autowired
    public CoOperationController(CoOperationService service) {
        this.service = service;
    }

    @PostMapping("/createcoOperation")
    public CoOperation createCoOperation(@RequestBody CoOperation coOperation){
        return service.CreateCoOperation(coOperation);
    }

    @GetMapping("/ListAllCoOperation")
    public List<CoOperation> getAllCoOperation(){
        return service.getAllCoOperation();
    }
}
