package com.ai.cobrother.Service;

import com.ai.cobrother.Model.CoOperation;
import com.ai.cobrother.Model.CoWorking;
import com.ai.cobrother.Repository.CoWorkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoWorkingService {

    public final CoWorkingRepo repo;

    @Autowired
    public CoWorkingService(CoWorkingRepo repo) {
        this.repo = repo;
    }

    public CoWorking createCoWorking(CoWorking cowork){
        return repo.save(cowork);
    }

    public List<CoWorking> getAllCoWorking(){
        return repo.findAll();
    }
}
