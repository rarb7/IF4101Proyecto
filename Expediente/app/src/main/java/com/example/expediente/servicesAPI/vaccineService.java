package com.example.expediente.servicesAPI;

import com.example.expediente.Models.PatientVaccine;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface vaccineService {
    @GET("Vacunas/{id}")
    Call<List<PatientVaccine>> obtainVaccines(@Path("id") int id);
}
