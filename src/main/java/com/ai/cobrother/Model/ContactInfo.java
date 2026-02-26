package com.ai.cobrother.Model;

import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection="contactInfo") me
public class ContactInfo {

//    private String fullName;
    private String email;
//    private String phoneCountryCode; // +91
    private String phoneNumber;       // 10-digit number

    // getters and setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
