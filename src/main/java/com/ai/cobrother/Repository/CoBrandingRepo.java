package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.CoVenture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoBrandingRepo extends MongoRepository<CoVenture,String> {
//    public CoBranding saveCoBrand(CoBranding cobrand, MultipartFile logo);
}
