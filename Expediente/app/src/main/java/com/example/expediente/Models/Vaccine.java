package com.example.expediente.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class Vaccine {

    @JsonProperty("vaccineId")
    private Integer vaccineId;
    @JsonProperty("vaccineName")
    private String vaccineName;
    @JsonProperty("vaccineDescription")
    private String vaccineDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vaccineId")
    public Integer getVaccineId() {
        return vaccineId;
    }

    @JsonProperty("vaccineId")
    public void setVaccineId(Integer vaccineId) {
        this.vaccineId = vaccineId;
    }

    @JsonProperty("vaccineName")
    public String getVaccineName() {
        return vaccineName;
    }

    @JsonProperty("vaccineName")
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    @JsonProperty("vaccineDescription")
    public String getVaccineDescription() {
        return vaccineDescription;
    }

    @JsonProperty("vaccineDescription")
    public void setVaccineDescription(String vaccineDescription) {
        this.vaccineDescription = vaccineDescription;
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
