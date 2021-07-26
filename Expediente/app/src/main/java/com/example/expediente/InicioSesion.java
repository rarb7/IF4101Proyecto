package com.example.expediente;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expediente.Models.Patient;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.servicesAPI.patienteService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InicioSesion extends AppCompatActivity {

    Button Entrar;
    Button Registro;
    TextView id;
    EditText password;
    ImageView icono;
    PatientSingleton singleton = PatientSingleton.getInstance();
    private Retrofit retrofit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Entrar = findViewById(R.id.btnEntrar);
        Registro = findViewById(R.id.registro);
        icono = findViewById(R.id.icono_ex);


        id = findViewById(R.id.txt_id);
        password = findViewById(R.id.id_pss);
        Entrar.setOnClickListener(v->{
            System.out.println("holaaa");
         retrofit= new Retrofit.Builder()
                 .baseUrl("https://webapiexpediente.azurewebsites.net/Api/Pacientes/")
                 .addConverterFactory(GsonConverterFactory.create())
                  .build();

            verificar(Integer.parseInt(this.id.getText().toString()),this.password.getText().toString());
        });

        Registro.setOnClickListener(v->{
            Intent intentMenu = new Intent(getApplicationContext(),Registro.class);
            //intentMenu.putExtra("id_Patient",Id);
            startActivity(intentMenu);
        });

    }

    public void verificar(int Id, String Password){

        Patient patient = new Patient();
        patient.setPatientId(Id);
        patient.setPatientPassword(Password);
        patienteService service  = retrofit.create(patienteService.class);
        Call<Void> RequestCall = service.obtainRespuesta(patient);

        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
    System.out.print(response.code());

                    if(response.code() == 200){

                        Intent intentMenu = new Intent(getApplicationContext(),MenuPrincipal.class);
                        //intentMenu.putExtra("id_Patient",Id);
                        singleton.setId(Id);
                        startActivity(intentMenu);

                    }else{


                    }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
  /*  public void verificar(){
        System.out.println("en verificar");
        allergyService service  = retrofit.create(allergyService.class);
       Call<ArrayList<PatientAllergy>> RequestCall = service.obtainAllergies(147147);

       RequestCall.enqueue(new Callback<ArrayList<PatientAllergy>>() {
           @Override
           public void onResponse(Call<ArrayList<PatientAllergy>> call, Response<ArrayList<PatientAllergy>> response) {

               ArrayList<PatientAllergy> list = response.body();
               System.out.println(list.get(0).getAllergy());
            //   System.out.println(list.get(1).getPatientId());
           }

           @Override
           public void onFailure(Call<ArrayList<PatientAllergy>> call, Throwable t) {

               System.out.println("OnFailure ---->"+t.getMessage());
           }
       });
    } */
}
