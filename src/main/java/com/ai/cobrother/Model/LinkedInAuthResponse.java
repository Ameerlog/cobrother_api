package com.ai.cobrother.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkedInAuthResponse {
    private String token;
    private String email;
    private String name;

    public LinkedInAuthResponse() {}

    public LinkedInAuthResponse(String token, String email, String name) {
        this.token = token;
        this.email = email;
        this.name = name;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
