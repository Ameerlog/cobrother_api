package com.ai.cobrother.Service;

import com.ai.cobrother.Model.SupportContactUs;
import com.ai.cobrother.Repository.SupportContactUsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportContactUsService {

    public final SupportContactUsRepo supportContactUsrepo;

    @Autowired
    public SupportContactUsService(SupportContactUsRepo supportContactUsrepo) {
        this.supportContactUsrepo = supportContactUsrepo;
    }


    public SupportContactUs CreateSupportContactUs(SupportContactUs supportContactUs){
        return supportContactUsrepo.save(supportContactUs);
    }
}
