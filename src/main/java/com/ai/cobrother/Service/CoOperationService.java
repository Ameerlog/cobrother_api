package com.ai.cobrother.Service;

import com.ai.cobrother.Model.CoMarketing;
import com.ai.cobrother.Model.CoOperation;
import com.ai.cobrother.Repository.CoOperationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoOperationService {

    public final CoOperationRepo repo;

    public CoOperationService(CoOperationRepo repo) {
        this.repo = repo;
    }

    public CoOperation CreateCoOperation(CoOperation cooperate){
        return repo.save(cooperate);
    }

    public List<CoOperation> getAllCoOperation(){
        return repo.findAll();
    }
}
