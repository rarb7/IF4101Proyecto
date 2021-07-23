package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class PatientAllergy {

    @JsonProperty("patientId")
    private Integer patientId;
    @JsonProperty("allergyId")
    private Integer allergyId;
    @JsonProperty("diagnosticDate")
    private String diagnosticDate;
    @JsonProperty("medication")
    private String medication;
    @JsonProperty("reasons")
    private String reasons;
    @JsonProperty("allergy")
    private Allergy allergy;
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

    @JsonProperty("allergyId")
    public Integer getAllergyId() {
        return allergyId;
    }

    @JsonProperty("allergyId")
    public void setAllergyId(Integer allergyId) {
        this.allergyId = allergyId;
    }

    @JsonProperty("diagnosticDate")
    public String getDiagnosticDate() {
        return diagnosticDate;
    }

    @JsonProperty("diagnosticDate")
    public void setDiagnosticDate(String diagnosticDate) {
        this.diagnosticDate = diagnosticDate;
    }

    @JsonProperty("medication")
    public String getMedication() {
        return medication;
    }

    @JsonProperty("medication")
    public void setMedication(String medication) {
        this.medication = medication;
    }

    @JsonProperty("reasons")
    public String getReasons() {
        return reasons;
    }

    @JsonProperty("reasons")
    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    @JsonProperty("allergy")
    public Allergy getAllergy() {
        return allergy;
    }

    @JsonProperty("allergy")
    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
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
