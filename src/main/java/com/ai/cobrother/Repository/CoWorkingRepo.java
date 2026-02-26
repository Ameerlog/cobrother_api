package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.CoWorking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoWorkingRepo extends MongoRepository<CoWorking,String> {
}
