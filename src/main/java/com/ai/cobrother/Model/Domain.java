package com.ai.cobrother.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class Domain {

    @Id
    private String id;

    private String domainName;
    private String domainExtension;
    private String domainCategory;
    private double askingPrice;
    private ContactInfo contactInfo;
    private Agreement agreement;
    private String logo;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainExtension() {
        return domainExtension;
    }

    public void setDomainExtension(String domainExtension) {
        this.domainExtension = domainExtension;
    }

    public String getDomainCategory() {
        return domainCategory;
    }

    public void setDomainCategory(String domainCategory) {
        this.domainCategory = domainCategory;
    }

    public double getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }


    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }
}
