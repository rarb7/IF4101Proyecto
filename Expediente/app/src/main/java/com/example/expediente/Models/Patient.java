package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class Patient {

    @JsonProperty("patientId")
    private Integer patientId;
    @JsonProperty("patientName")
    private String patientName;
    @JsonProperty("patientLastname")
    private String patientLastname;
    @JsonProperty("patientPassword")
    private String patientPassword;
    @JsonProperty("patientAge")
    private Integer patientAge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("patientId")
    public Integer getPatientId() {
        return patientId;
    }

    @JsonProperty("patientId")
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @JsonProperty("patientName")
    public String getPatientName() {
        return patientName;
    }

    @JsonProperty("patientName")
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @JsonProperty("patientLastname")
    public String getPatientLastname() {
        return patientLastname;
    }

    @JsonProperty("patientLastname")
    public void setPatientLastname(String patientLastname) {
        this.patientLastname = patientLastname;
    }

    @JsonProperty("patientPassword")
    public String getPatientPassword() {
        return patientPassword;
    }

    @JsonProperty("patientPassword")
    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    @JsonProperty("patientAge")
    public Integer getPatientAge() {
        return patientAge;
    }

    @JsonProperty("patientAge")
    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
