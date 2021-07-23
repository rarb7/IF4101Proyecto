package com.example.expediente.servicesAPI;

import com.example.expediente.Models.PatientAllergy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface allergyService {

    @GET("Alergias/{id}")
    Call<List<PatientAllergy>> obtainAllergies(@Path("id") int id);
}
