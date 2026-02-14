package com.ai.cobrother.Repository;

import com.ai.cobrother.Model.CoBranding;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface CoBrandingRepo extends MongoRepository<CoBranding,String> {
//    public CoBranding saveCoBrand(CoBranding cobrand, MultipartFile logo);
}
