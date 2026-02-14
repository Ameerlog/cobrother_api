package com.ai.cobrother.Service;

import com.ai.cobrother.Model.CoBranding;
import com.ai.cobrother.Model.CoCreation;
import com.ai.cobrother.Repository.CoCreationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoCreationService {

    public final CoCreationRepo repo;

    @Autowired
    public CoCreationService(CoCreationRepo repo) {
        this.repo = repo;
    }


    public CoCreation CreateCoCreation(CoCreation cocreate){
        return repo.save(cocreate);
    }

    public List<CoCreation> getAllCoCreation(){
        return repo.findAll();
    }

}
