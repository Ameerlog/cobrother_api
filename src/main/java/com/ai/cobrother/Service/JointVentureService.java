package com.ai.cobrother.Service;

import com.ai.cobrother.Model.Venture;
import com.ai.cobrother.Repository.JointVentureRepo;
import org.springframework.stereotype.Service;

@Service
public class JointVentureService {

    public final JointVentureRepo repo;

    public JointVentureService(JointVentureRepo repo) {
        this.repo = repo;
    }

    public Venture createJointVenture(Venture jv){
        return repo.save(jv);
    }
}
