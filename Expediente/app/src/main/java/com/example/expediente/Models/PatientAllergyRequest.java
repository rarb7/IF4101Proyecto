package com.example.expediente.Models;

import java.util.ArrayList;

public class PatientAllergyRequest {
    public ArrayList<PatientVaccine> getResults() {
        return results;
    }

    public void setResults(ArrayList<PatientVaccine> results) {
        this.results = results;
    }

    private ArrayList<PatientVaccine> results;
}
