package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Details {

    @JsonProperty("PatientId")
    private Integer patientId;
    @JsonProperty("BloodType")
    private String bloodType;
    @JsonProperty("MaritalStatus")
    private String maritalStatus;
    @JsonProperty("Phone")
    private String phone;
//    @JsonProperty("patient")
//    private Patient patient;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PatientId")
    public Integer getPatientId() {
        return patientId;
    }

    @JsonProperty("PatientId")
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @JsonProperty("BloodType")
    public String getBloodType() {
        return bloodType;
    }

    @JsonProperty("BloodType")
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @JsonProperty("MaritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("MaritalStatus")
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @JsonProperty("Phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

//    @JsonProperty("patient")
//    public Patient getPatient() {
//        return patient;
//    }
//
//    @JsonProperty("patient")
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
