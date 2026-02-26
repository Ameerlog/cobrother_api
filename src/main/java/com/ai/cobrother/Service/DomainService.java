package com.ai.cobrother.Service;

import com.ai.cobrother.Model.CoWorking;
import com.ai.cobrother.Model.Domain;
import com.ai.cobrother.Repository.DomainRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainService {

    public final DomainRepo domainRepo;

    public DomainService(DomainRepo domainRepo) {
        this.domainRepo = domainRepo;
    }

    public Domain CreateDomains(Domain domain){
        return domainRepo.save(domain);
    }

    public List<Domain> getAllDomains(){
        return domainRepo.findAll();
    }

    public Domain getDomainById(String id){
        return domainRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Domain not found with id: " + id));
    }
}
