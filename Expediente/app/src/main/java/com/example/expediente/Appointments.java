package com.example.expediente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expediente.Adapters.AppointmentListAdapter;
import com.example.expediente.Models.PatientAppointment;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.servicesAPI.appointmentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Appointments extends AppCompatActivity {

    private RecyclerView ListRecycler;//apunta al elemento con el que quiero trabajar en el view
    private Retrofit retrofit;
    private AppointmentListAdapter ListA;
    List<PatientAppointment> jojo;
    TextView listaVacia;
    private AppointmentListAdapter.RecyclerViewClickListener listener;
    PatientSingleton singleton = PatientSingleton.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        setOnClickListener();
        ListA = new AppointmentListAdapter(this,listener);
    listaVacia = findViewById(R.id.lista_App);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListRecycler = findViewById(R.id.appointmentRecyclerView);
        ListRecycler.setHasFixedSize(true);
        ListRecycler.setLayoutManager(llm);

        ListRecycler.setAdapter(ListA);

        retrofit= new Retrofit.Builder()
                .baseUrl("https://webapiexpediente.azurewebsites.net/Api/Pacientes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtain_vaccines();



        // obtain_vaccines();

    }

    private void obtain_vaccines(){

        appointmentService service  = retrofit.create(appointmentService.class);
        Call<List<PatientAppointment>> RequestCall = service.obtainAppointment(singleton.getId());

        RequestCall.enqueue(new Callback<List<PatientAppointment>>() {



            @Override
            public void onResponse(Call<List<PatientAppointment>> call, Response<List<PatientAppointment>> response) {
                if(response.isSuccessful()) {//si la respuesta es existosa
                    List<PatientAppointment> list = response.body();

                    jojo = list;
                    if(list.isEmpty()){
                        listaVacia.setVisibility(View.VISIBLE);
                    }
                    ListA.addAppointment(new ArrayList(list));

                    ListA.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<List<PatientAppointment>> call, Throwable t) {

                System.out.println("OnFailure ---->"+t.getMessage());
            }
        });

    }//fin obtener las vacunas

    private void setOnClickListener() {
        listener = new AppointmentListAdapter.RecyclerViewClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),AppointmentInfo.class);
                intent.putExtra("dia",jojo.get(position).getDrAppDay());
                intent.putExtra("hora",jojo.get(position).getDrAppHour());
                intent.putExtra("especialidad",jojo.get(position).getSpecialty().getEspecialidadNombre());
                intent.putExtra("details",jojo.get(position).getDetails());
                startActivity(intent);
            }//se envia el nuevo activity al darle click a nuestro objeto
        };
    }
}
