package com.ai.cobrother.Model;

import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection="agreement") me
public class Agreement {

    private boolean terms;
//    private boolean partnershipConsent;

    // getters and setters

    public boolean isTermsAccepted() {
        return terms;
    }

    public void setTermsAccepted(boolean terms) {
        this.terms = terms;
    }

//    public boolean isPartnershipConsent() {
//        return partnershipConsent;
//    }
//
//    public void setPartnershipConsent(boolean partnershipConsent) {
//        this.partnershipConsent = partnershipConsent;
//    }
}
