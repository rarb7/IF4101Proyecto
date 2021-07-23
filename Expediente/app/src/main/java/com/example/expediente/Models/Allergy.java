package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class Allergy {
    @JsonProperty("allergyId")
    private Integer allergyId;
    @JsonProperty("allergyName")
    private String allergyName;
    @JsonProperty("allergyDescription")
    private String allergyDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("allergyId")
    public Integer getAllergyId() {
        return allergyId;
    }

    @JsonProperty("allergyId")
    public void setAllergyId(Integer allergyId) {
        this.allergyId = allergyId;
    }

    @JsonProperty("allergyName")
    public String getAllergyName() {
        return allergyName;
    }

    @JsonProperty("allergyName")
    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    @JsonProperty("allergyDescription")
    public String getAllergyDescription() {
        return allergyDescription;
    }

    @JsonProperty("allergyDescription")
    public void setAllergyDescription(String allergyDescription) {
        this.allergyDescription = allergyDescription;
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
