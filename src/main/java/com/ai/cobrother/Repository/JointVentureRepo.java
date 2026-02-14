package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.Venture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointVentureRepo extends MongoRepository<Venture,String> {
}
