package com.example.expediente.servicesAPI;

import com.example.expediente.Models.PatientAppointment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface appointmentService {

    @GET("Citas/{id}")
    Call<List<PatientAppointment>> obtainAppointment(@Path("id") int id);
}
