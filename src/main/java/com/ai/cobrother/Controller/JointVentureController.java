package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.Venture;
import com.ai.cobrother.Service.JointVentureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class JointVentureController {

    public final JointVentureService service;

    @Autowired
    public JointVentureController(JointVentureService service) {
        this.service = service;
    }


    @PostMapping("/CreateJointVenture")
    public Venture CreateJointVenture(@RequestBody Venture jv){
        return service.createJointVenture(jv);
    }
}
