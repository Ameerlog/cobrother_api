package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.CoMarketing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoMarketingRepo extends MongoRepository<CoMarketing,String> {
}
