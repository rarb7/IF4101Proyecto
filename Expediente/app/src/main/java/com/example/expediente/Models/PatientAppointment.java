package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class PatientAppointment {
    @JsonProperty("patientId")
    private Integer patientId;
    @JsonProperty("centerId")
    private Integer centerId;
    @JsonProperty("drAppDay")
    private String drAppDay;
    @JsonProperty("drAppHour")
    private String drAppHour;
    @JsonProperty("details")
    private String details;
    @JsonProperty("specialtyId")
    private Integer specialtyId;
    @JsonProperty("center")
    private Center center;
    @JsonProperty("patient")
    private Patient patient;
    @JsonProperty("specialty")
    private Specialty specialty;
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

    @JsonProperty("centerId")
    public Integer getCenterId() {
        return centerId;
    }

    @JsonProperty("centerId")
    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    @JsonProperty("drAppDay")
    public String getDrAppDay() {
        return drAppDay;
    }

    @JsonProperty("drAppDay")
    public void setDrAppDay(String drAppDay) {
        this.drAppDay = drAppDay;
    }

    @JsonProperty("drAppHour")
    public String getDrAppHour() {
        return drAppHour;
    }

    @JsonProperty("drAppHour")
    public void setDrAppHour(String drAppHour) {
        this.drAppHour = drAppHour;
    }

    @JsonProperty("details")
    public String getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(String details) {
        this.details = details;
    }

    @JsonProperty("specialtyId")
    public Integer getSpecialtyId() {
        return specialtyId;
    }

    @JsonProperty("specialtyId")
    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    @JsonProperty("center")
    public Center getCenter() {
        return center;
    }

    @JsonProperty("center")
    public void setCenter(Center center) {
        this.center = center;
    }

    @JsonProperty("patient")
    public Patient getPatient() {
        return patient;
    }

    @JsonProperty("patient")
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JsonProperty("specialty")
    public Specialty getSpecialty() {
        return specialty;
    }

    @JsonProperty("specialty")
    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
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
