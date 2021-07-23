package com.example.expediente.servicesAPI;

import com.example.expediente.Models.Address;
import com.example.expediente.Models.Details;
import com.example.expediente.Models.Patient;
import com.example.expediente.Models.PatientInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface patienteService {

    //@FormUrlEncoded
    @POST("verificar/")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Void> obtainRespuesta(@Body Patient patient);

    @GET("Informacion/{id}")
    Call<List<PatientInformation>> obtainInformacion(@Path("id") int id);

    //actualizar la informacion del paciente
    @PUT("Detalles/Editar/Informacion/{status}/{phone}/{id}")

    //@Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Void> editarInformacion( @Path("status")String status ,@Path("phone") String telefono ,@Path("id") int id);

    @PUT("Detalles/Editar/Direccion/{id}")
   // @Headers({ "Content-Type: application/json"})
   @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Void> editarDireccion(@Body Address direccion , @Path("id") int id);

    //para guardar
    @POST("Registrar/")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Void> guardarPaciente(@Body Patient patient);

    @POST("Direccion/")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Void> guardarDireccion(@Body Address patient);

    @POST("Detalles/Registrar/Informacion/")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Void> guardarInformacion(@Body Details patient);

}
