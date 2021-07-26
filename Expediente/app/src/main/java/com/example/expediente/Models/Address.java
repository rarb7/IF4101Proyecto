package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Address {
    @JsonProperty("PatientId")
    private Integer patientId;
    @JsonProperty("Provincia")
    private String provincia;
    @JsonProperty("Canton")
    private String canton;
    @JsonProperty("Distrito")
    private String distrito;
    @JsonProperty("OtrasSennas")
    private String otrasSennas;
    //@JsonProperty("patient")
   // private Patient patient;
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

    @JsonProperty("Provincia")
    public String getProvincia() {
        return provincia;
    }

    @JsonProperty("Provincia")
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @JsonProperty("Canton")
    public String getCanton() {
        return canton;
    }

    @JsonProperty("Canton")
    public void setCanton(String canton) {
        this.canton = canton;
    }

    @JsonProperty("Distrito")
    public String getDistrito() {
        return distrito;
    }

    @JsonProperty("Distrito")
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @JsonProperty("OtrasSennas")
    public String getOtrasSennas() {
        return otrasSennas;
    }

    @JsonProperty("OtrasSennas")
    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
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
