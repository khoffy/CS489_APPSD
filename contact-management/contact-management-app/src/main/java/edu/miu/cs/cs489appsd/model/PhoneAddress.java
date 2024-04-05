package edu.miu.cs.cs489appsd.model;

import java.util.HashMap;
import java.util.Map;

public class PhoneAddress {
    private Long id;
    private String number;
    private Map<String, String> labels;

    public PhoneAddress() {}

    public PhoneAddress(Long id, String number) {
        this.id = id;
        this.number = number;
        this.labels = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
}
