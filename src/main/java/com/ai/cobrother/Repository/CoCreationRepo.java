package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.CoBranding;
import com.ai.cobrother.Model.CoCreation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoCreationRepo extends MongoRepository<CoCreation,String>  {
}
