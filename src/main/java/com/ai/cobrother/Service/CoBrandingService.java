package com.ai.cobrother.Service;

import com.ai.cobrother.Model.CoVenture;
import com.ai.cobrother.Repository.CoBrandingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoBrandingService {

    public final CoBrandingRepo cobrandrepo;

    @Autowired
    public CoBrandingService(CoBrandingRepo cobrandrepo) {
        this.cobrandrepo = cobrandrepo;
    }

    public CoVenture CreateCoBranding(CoVenture cobrand){
       return cobrandrepo.save(cobrand);
    }

    public List<CoVenture> getAllBrands(){
        return cobrandrepo.findAll();
    }
}
