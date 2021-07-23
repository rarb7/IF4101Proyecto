package com.example.expediente.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class SendAddress {
    @JsonProperty("patientId")
    private Integer patientId;
    @JsonProperty("provincia")
    private String provincia;
    @JsonProperty("canton")
    private String canton;
    @JsonProperty("distrito")
    private String distrito;
    @JsonProperty("otrasSennas")
    private String otrasSennas;

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

    @JsonProperty("provincia")
    public String getProvincia() {
        return provincia;
    }

    @JsonProperty("provincia")
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @JsonProperty("canton")
    public String getCanton() {
        return canton;
    }

    @JsonProperty("canton")
    public void setCanton(String canton) {
        this.canton = canton;
    }

    @JsonProperty("distrito")
    public String getDistrito() {
        return distrito;
    }

    @JsonProperty("distrito")
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @JsonProperty("otrasSennas")
    public String getOtrasSennas() {
        return otrasSennas;
    }

    @JsonProperty("otrasSennas")
    public void setOtrasSennas(String otrasSennas) {
        this.otrasSennas = otrasSennas;
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
