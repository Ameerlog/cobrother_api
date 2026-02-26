package com.ai.cobrother.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "coworking")
public class CoWorking {

    @Id
    private String Id;

    @Field("full_name")
    private String fullName;

    @Field("primaryRole")
    private String primaryRole;

    @Field("LinkedinUrl")
    private String linkedinUrl;

    @Field("skillset")
    private String skill;

    @Field("agreement")
    private Agreement agreement;

    @Field("logo")
    private String logo;

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getId(){
        return Id;
    }

    public void setId(String id) {
        this.Id=id;
    }

    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }

    public String getPrimaryRole(){
        return primaryRole;
    }

    public void setPrimaryRole(String primaryRole){
        this.primaryRole=primaryRole;
    }


    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
