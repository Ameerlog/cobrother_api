package com.ai.cobrother.Service;

import com.ai.cobrother.Model.CoBranding;
import com.ai.cobrother.Repository.CoBrandingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CoBrandingService {

    public final CoBrandingRepo cobrandrepo;

    @Autowired
    public CoBrandingService(CoBrandingRepo cobrandrepo) {
        this.cobrandrepo = cobrandrepo;
    }

    public CoBranding CreateCoBranding(CoBranding cobrand){
       return cobrandrepo.save(cobrand);
    }

    public List<CoBranding> getAllBrands(){
        return cobrandrepo.findAll();
    }
}
