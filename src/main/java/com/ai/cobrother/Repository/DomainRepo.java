package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepo extends MongoRepository<Domain,String> {
}
