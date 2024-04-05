package edu.miu.cs.cs489appsd.model;

import java.util.HashMap;
import java.util.Map;

public class EmailAddress {
    private Long id;
    private String email;
    private Map<String, String> labels;

    public EmailAddress() {}

    public EmailAddress(Long id, String email) {
        this.id = id;
        this.email = email;
        this.labels = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
}
