package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.CoOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoOperationRepo extends MongoRepository<CoOperation,String> {
}
