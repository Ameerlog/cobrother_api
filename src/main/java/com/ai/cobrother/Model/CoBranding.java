    package com.ai.cobrother.Model;

    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;

    @Document(collection = "CoBranding")
    public class CoBranding {

            @Id
            private String id;
            private BrandDetails brandDetails;
            private ContactInfo contactInfo;
            private Agreement agreement;

            // getters and setters

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public BrandDetails getBrandDetails() {
                return brandDetails;
            }

            public void setBrandDetails(BrandDetails brandDetails) {
                this.brandDetails = brandDetails;
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
