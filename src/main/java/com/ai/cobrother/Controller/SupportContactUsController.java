package com.ai.cobrother.Controller;

import com.ai.cobrother.Model.SupportContactUs;
import com.ai.cobrother.Service.SupportContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class SupportContactUsController {

    public final SupportContactUsService service;

    @Autowired
    public SupportContactUsController(SupportContactUsService service) {
        this.service = service;
    }

    @PostMapping("/SupportContactUs")
    public SupportContactUs createSupportContactUs(@RequestBody SupportContactUs supportContactUs){
        return service.CreateSupportContactUs(supportContactUs);
    }
}
