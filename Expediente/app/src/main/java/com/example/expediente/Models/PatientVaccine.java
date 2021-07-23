package com.example.expediente.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class PatientVaccine {

    @JsonProperty("patientId")
    private Integer patientId;
    @JsonProperty("vaccineId")
    private Integer vaccineId;
    @JsonProperty("vAppDate")
    private String vAppDate;
    @JsonProperty("nextAppDate")
    private String nextAppDate;
    @JsonProperty("reasons")
    private Object reasons;
    @JsonProperty("patient")
    private Patient patient;
    @JsonProperty("vaccine")
    private Vaccine vaccine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public PatientVaccine(int i, int i1, String s, String s1) {
        this.patientId =i;
        this.vaccineId = i1;
        this.vAppDate = s;
        this.reasons= s1;
    }

    @JsonProperty("patientId")
    public Integer getPatientId() {
        return patientId;
    }

    @JsonProperty("patientId")
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @JsonProperty("vaccineId")
    public Integer getVaccineId() {
        return vaccineId;
    }

    @JsonProperty("vaccineId")
    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    @JsonProperty("vAppDate")
    public String getvAppDate() {
        return vAppDate;
    }

    @JsonProperty("vAppDate")
    public void setvAppDate(String vAppDate) {
        this.vAppDate = vAppDate;
    }

    @JsonProperty("nextAppDate")
    public String getNextAppDate() {
        return nextAppDate;
    }

    @JsonProperty("nextAppDate")
    public void setNextAppDate(String nextAppDate) {
        this.nextAppDate = nextAppDate;
    }

    @JsonProperty("reasons")
    public Object getReasons() {
        return reasons;
    }

    @JsonProperty("reasons")
    public void setReasons(Object reasons) {
        this.reasons = reasons;
    }

    @JsonProperty("patient")
    public Patient getPatient() {
        return patient;
    }

    @JsonProperty("patient")
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JsonProperty("vaccine")
    public Vaccine getVaccine() {
        return vaccine;
    }

    @JsonProperty("vaccine")
    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
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
