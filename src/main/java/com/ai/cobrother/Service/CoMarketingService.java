package com.ai.cobrother.Service;

import com.ai.cobrother.Model.CoCreation;
import com.ai.cobrother.Model.CoMarketing;
import com.ai.cobrother.Repository.CoMarketingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoMarketingService {

    public final CoMarketingRepo repo;

    @Autowired
    public CoMarketingService(CoMarketingRepo repo) {
        this.repo = repo;
    }

    public CoMarketing CreateCoMarketing(CoMarketing comarket){
        return repo.save(comarket);
    }

    public List<CoMarketing> getAllCoMarketing(){
        return repo.findAll();
    }
}
