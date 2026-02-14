package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.SupportContactUs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportContactUsRepo extends MongoRepository<SupportContactUs,String> {
}
