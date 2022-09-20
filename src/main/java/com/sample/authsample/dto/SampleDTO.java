package com.sample.authsample.dto;

import java.util.List;

public class SampleDTO {

    private boolean autheticated;
    private String id;
    public boolean isAutheticated() {
        return autheticated;
    }

    public void setAutheticated(boolean autheticated) {
        this.autheticated = autheticated;
    }

    public boolean getAuthenticated() {
        return isAutheticated();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
