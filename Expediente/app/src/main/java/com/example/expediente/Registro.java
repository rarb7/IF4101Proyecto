package com.example.expediente;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expediente.Models.Address;
import com.example.expediente.Models.Details;
import com.example.expediente.Models.Patient;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.servicesAPI.patienteService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registro extends AppCompatActivity {

    Button GuardarInfo;
    Button GuardarAddress;
    Button GuardarPaciente;

    //para obtener la info
    EditText nombre;
    EditText id;
    EditText apellido;
    EditText edad;
    EditText password;
    TextView tipoSangre;

    EditText estadoCivil;
    EditText telefono;
    EditText provincia;
    EditText canton;
    EditText distrito;
    EditText otros;

    //para edicion
    private Retrofit retrofit;
    PatientSingleton singleton = PatientSingleton.getInstance();
    Patient patient;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        retrofit= new Retrofit.Builder()
                .baseUrl("https://webapiexpediente.azurewebsites.net/Api/Pacientes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        initComponent();
        initButtons();

    }

    private void initButtons(){
        GuardarInfo.setOnClickListener(v->{

            guardarInfo();

        });

        GuardarAddress.setOnClickListener(v->{

            guardarDireccion();

        });
        GuardarPaciente.setOnClickListener(v->{

            guardarPaciente();
        });


    }

    private void guardarPaciente() {

         patient = new Patient();
        patient.setPatientId(Integer.parseInt(id.getText().toString()));
        patient.setPatientName(nombre.getText().toString());
        patient.setPatientPassword(password.getText().toString());
        patient.setPatientLastname(apellido.getText().toString());
        patient.setPatientAge(Integer.parseInt(edad.getText().toString()));

        System.out.println("estoy en registrar");

        patienteService service  = retrofit.create(patienteService.class);
        System.out.println("despues del service");
        Call<Void> RequestCall = service.guardarPaciente(patient);
        System.out.println("despues del call");
        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {


                if(response.code() == 200){
                        System.out.println("registrado");
                }else{


                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println( "error---->"+ t.getMessage());
            }
        });
    }

    private void guardarInfo() {
        Details patient = new Details();
        patient.setPatientId(Integer.parseInt(id.getText().toString()));
        patient.setMaritalStatus(estadoCivil.getText().toString());
        patient.setPhone(telefono.getText().toString());
        patient.setBloodType(tipoSangre.getText().toString());


        System.out.println("estoy en registrar");

        patienteService service  = retrofit.create(patienteService.class);
        System.out.println("despues del service");
        Call<Void> RequestCall = service.guardarInformacion(patient);
        System.out.println("despues del call");
        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {


                if(response.code() == 200){
                    System.out.println("registrado");
                }else{


                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println( "error---->"+ t.getMessage());
            }
        });
    }

    private void guardarDireccion() {

        Address patient = new Address();
        patient.setPatientId(Integer.parseInt(id.getText().toString()));
        patient.setProvincia(nombre.getText().toString());
        patient.setCanton(canton.getText().toString());
        patient.setDistrito(distrito.getText().toString());
        patient.setOtrasSennas(otros.getText().toString());


        System.out.println("estoy en registrar");

        patienteService service  = retrofit.create(patienteService.class);
        System.out.println("despues del service");
        Call<Void> RequestCall = service.guardarDireccion(patient);
        System.out.println("despues del call");
        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                System.out.println(response.code());
//                if(response.code() == 200){
//                    System.out.println("registrado");
//                }else{
//
//
//                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println( "error---->"+ t.getMessage());
            }
        });
    }

    private void initComponent(){
        nombre = findViewById(R.id.rusername);
        id = findViewById(R.id.cedula);
        apellido = findViewById(R.id.ruserlastname);
        edad  = findViewById(R.id.redad);
        password  = findViewById(R.id.userPass);

        tipoSangre = findViewById(R.id.userMS);
        estadoCivil = findViewById(R.id.userBT);
        telefono = findViewById(R.id.userPhone);

        provincia = findViewById(R.id.userProvincia);
        canton = findViewById(R.id.userCanton);
        distrito = findViewById(R.id.userDistrito);
        otros = findViewById(R.id.userOtras);


        GuardarPaciente = findViewById(R.id.SafeP);

        GuardarInfo= findViewById(R.id.btnSafeInfo);
        GuardarAddress = findViewById(R.id.tbSafeAddress);
    }
}
