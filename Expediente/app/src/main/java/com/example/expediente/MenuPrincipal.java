package com.example.expediente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expediente.Models.PatientInformation;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.servicesAPI.patienteService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuPrincipal extends AppCompatActivity {
    //botones
    Button vaccines;
    Button allergies;
    Button citas;
    Button Informacion;
    Button salir;
    //obtener informacion
    PatientSingleton singleton = PatientSingleton.getInstance();
    PatientInformation information ;
    //api
    String nombre, lastname, age, BT, MT,Phone,province,canton,distrito,otros , edad;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        retrofit= new Retrofit.Builder()
                .baseUrl("https://webapiexpediente.azurewebsites.net/Api/Pacientes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtainInfo(singleton.getId());
        vaccines = findViewById(R.id.btn_vacunas);
        salir = findViewById(R.id.btnSalir);
        allergies = findViewById(R.id.btnAllergy);
        citas = findViewById(R.id.btnAppointment);
        Informacion = findViewById(R.id.btn_details);

        vaccines.setOnClickListener(v->{

            Intent intentMenu = new Intent(getApplicationContext(),Vaccines.class);
            //intentMenu.putExtra("id_Patient",getIntent().getIntExtra("id_Patient",1));
            startActivity(intentMenu);

        });

        allergies.setOnClickListener(v->{
            Intent intentMenu = new Intent(getApplicationContext(),Allergies.class);
            //intentMenu.putExtra("id_Patient",getIntent().getIntExtra("id_Patient",1));
            startActivity(intentMenu);
        });

        citas.setOnClickListener(v->{
            Intent intentMenu = new Intent(getApplicationContext(),Appointments.class);
            //intentMenu.putExtra("id_Patient",getIntent().getIntExtra("id_Patient",1));
            startActivity(intentMenu);
        });

        Informacion.setOnClickListener(v->{

            openIntent();
            //intentMenu.putExtra("id_Patient",getIntent().getIntExtra("id_Patient",1));
        });

        salir.setOnClickListener(this::onClick);
    }

    private void openIntent() {
        Intent intent = new Intent(getApplicationContext(),UserInfo.class);
      //  System.out.println(information.getAddress().getDistrito());
        intent.putExtra("userName",nombre);
        intent.putExtra("LastName",lastname);
        intent.putExtra("Age",edad);

        intent.putExtra("BT",BT);
        intent.putExtra("MS",MT);
        intent.putExtra("Phone",Phone);

        intent.putExtra("Province",province);
        intent.putExtra("Canton",canton);
        intent.putExtra("Distrito",distrito);
        intent.putExtra("OS",otros);

        startActivity(intent);
    }

    private void obtainInfo(int id){

        patienteService service  = retrofit.create(patienteService.class);
        Call<List<PatientInformation>> RequestCall = service.obtainInformacion(id);

        RequestCall.enqueue(new Callback<List<PatientInformation>>() {



            @Override
            public void onResponse(Call<List<PatientInformation>> call, Response<List<PatientInformation>> response) {
                if(response.isSuccessful()) {//si la respuesta es existosa
                   List<PatientInformation> list = response.body();
                    nombre = list.get(0).getPatient().getPatientName();

                    lastname = list.get(0).getPatient().getPatientLastname();
                    edad = String.valueOf(list.get(0).getPatient().getPatientAge());

                     BT= list.get(0).getDetails().getBloodType();
                    MT=list.get(0).getDetails().getMaritalStatus();
                    Phone = list.get(0).getDetails().getPhone();

                    province = list.get(0).getAddress().getProvincia();
        canton = list.get(0).getAddress().getCanton();
                    distrito = list.get(0).getAddress().getDistrito();
        otros = list.get(0).getAddress().getOtrasSennas();
//
              //      information = list;
//                    PatientInformation p = new PatientInformation();
//                    p.setAddress(list.get(0).getAddress());
//                    p.setDetails(list.get(0).getDetails());
//                    p.setPatient(list.get(0).getPatient());
                //   System.out.println(information.get(0).getAddress().getDistrito());
//                    singleton.setInformation(p);
//                    ListA.addAppointment(new ArrayList(list));
//
//                    ListA.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<List<PatientInformation>> call, Throwable t) {

                System.out.println("OnFailure ---->"+t.getMessage());
            }
        });

    }

    private void onClick(View v) {
        //onDestroy();
        Intent intentMenu = new Intent(getApplicationContext(), InicioSesion.class);

        startActivity(intentMenu);
    }
}
