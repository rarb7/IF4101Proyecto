package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class Center {
    @JsonProperty("centerId")
    private Integer centerId;
    @JsonProperty("centerName")
    private String centerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("centerId")
    public Integer getCenterId() {
        return centerId;
    }

    @JsonProperty("centerId")
    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    @JsonProperty("centerName")
    public String getCenterName() {
        return centerName;
    }

    @JsonProperty("centerName")
    public void setCenterName(String centerName) {
        this.centerName = centerName;
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
