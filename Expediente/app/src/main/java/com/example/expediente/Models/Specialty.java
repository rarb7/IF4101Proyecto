package com.example.expediente.Models;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
public class Specialty {
    @JsonProperty("especialidadId")
    private Integer especialidadId;
    @JsonProperty("especialidadNombre")
    private String especialidadNombre;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("especialidadId")
    public Integer getEspecialidadId() {
        return especialidadId;
    }

    @JsonProperty("especialidadId")
    public void setEspecialidadId(Integer especialidadId) {
        this.especialidadId = especialidadId;
    }

    @JsonProperty("especialidadNombre")
    public String getEspecialidadNombre() {
        return especialidadNombre;
    }

    @JsonProperty("especialidadNombre")
    public void setEspecialidadNombre(String especialidadNombre) {
        this.especialidadNombre = especialidadNombre;
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
