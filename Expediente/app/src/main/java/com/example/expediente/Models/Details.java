package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class Details {

    @JsonProperty("patientId")
    private Integer patientId;
    @JsonProperty("bloodType")
    private String bloodType;
    @JsonProperty("maritalStatus")
    private String maritalStatus;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("patient")
    private Patient patient;
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

    @JsonProperty("bloodType")
    public String getBloodType() {
        return bloodType;
    }

    @JsonProperty("bloodType")
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @JsonProperty("maritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("maritalStatus")
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("patient")
    public Patient getPatient() {
        return patient;
    }

    @JsonProperty("patient")
    public void setPatient(Patient patient) {
        this.patient = patient;
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
