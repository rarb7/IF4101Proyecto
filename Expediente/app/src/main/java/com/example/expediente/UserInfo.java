package com.example.expediente;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expediente.Models.Address;
import com.example.expediente.Models.Details;
import com.example.expediente.Models.PatientInformation;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.servicesAPI.patienteService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserInfo extends AppCompatActivity {

    //para la informacion
    TextView nombre;
    TextView apellido;
    TextView edad;
    TextView tipoSangre;

    EditText estadoCivil;
    EditText telefono;
    EditText provincia;
    EditText canton;
    EditText distrito;
    EditText otros;

    //para habilitar la edicion
    Button editarInfo;
    Button editarAddress;
    Button GuardarInfo;
    Button GuardarAddress;

    //para edicion
    private Retrofit retrofit;
    PatientSingleton singleton = PatientSingleton.getInstance();

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        retrofit= new Retrofit.Builder()
                .baseUrl("https://webapiexpediente.azurewebsites.net/api/Informacion/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        initComponents();
        obtainInfo(singleton.getId());
        initButtons();
    }

    private void obtainInfo(int id){

        patienteService service  = retrofit.create(patienteService.class);
        Call<List<PatientInformation>> RequestCall = service.obtainInformacion(id);

        RequestCall.enqueue(new Callback<List<PatientInformation>>() {



            @Override
            public void onResponse(Call<List<PatientInformation>> call, Response<List<PatientInformation>> response) {
                if(response.isSuccessful()) {//si la respuesta es existosa
                    List<PatientInformation> list = response.body();

                    nombre.setText(list.get(0).getPatient().getPatientName());
                    apellido.setText(list.get(0).getPatient().getPatientLastname());
                    edad.setText(String.valueOf(list.get(0).getPatient().getPatientAge()));

                    if(list.get(0).getDetails() != null){
                        tipoSangre.setText(list.get(0).getDetails().getBloodType());
                        estadoCivil.setText(list.get(0).getDetails().getMaritalStatus());
                        telefono.setText(list.get(0).getDetails().getPhone());
                    }

                    if(list.get(0).getAddress() != null){
                        provincia.setText(list.get(0).getAddress().getProvincia());
                        canton.setText(list.get(0).getAddress().getCanton());
                        distrito.setText(list.get(0).getAddress().getDistrito());
                        otros.setText(list.get(0).getAddress().getOtrasSennas());

                    }

                }
            }

            @Override
            public void onFailure(Call<List<PatientInformation>> call, Throwable t) {

                System.out.println("OnFailure ---->"+t.getMessage());
            }
        });

    }
    private void initButtons(){
        editarInfo= findViewById(R.id.btnInfoedit);
        editarAddress = findViewById(R.id.editarAddress);

        GuardarInfo= findViewById(R.id.btnupdateInfo);
        GuardarAddress = findViewById(R.id.btnUpdateAddress);

        editarInfo.setOnClickListener(v->{

                estadoCivil.setEnabled(true);
                telefono.setEnabled(true);


        });

        editarAddress.setOnClickListener(v->{
            provincia.setEnabled(true);
            canton.setEnabled(true);
            distrito.setEnabled(true);
            otros.setEnabled(true);
        });

        GuardarInfo.setOnClickListener(v->{

            guardarInfo();

        });

        GuardarAddress.setOnClickListener(v->{

            guardarDireccion();

        });
    }

    private void guardarInfo() {

        Details details  = new Details();
        details.setPatientId(singleton.getId());
        details.setBloodType(tipoSangre.getText().toString());
        details.setPhone(telefono.getText().toString());
        details.setMaritalStatus(estadoCivil.getText().toString());
        patienteService service  = retrofit.create(patienteService.class);

        Call<Void> RequestCall = service.editarInformacion(singleton.getId(),details);

        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

               // Log.e("API actualizar info",response.message());
                if(response.code() == 200){

                   // System.out.println("ACTUALIZADO CORRECTAMENTE");
                    estadoCivil.setEnabled(false);
                    telefono.setEnabled(false);
                }else{


                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }//fin guardarInfo

    private void  guardarDireccion() {

        Address address  = new Address();
        address.setPatientId(singleton.getId());
        address.setProvincia(provincia.getText().toString());
        address.setCanton(canton.getText().toString());
        address.setDistrito(distrito.getText().toString());
        address.setOtrasSennas(otros.getText().toString());

        System.out.println("ACTUALIZANDO");
        System.out.println(address.getPatientId());
        System.out.println(address.getOtrasSennas());
        //System.out.println(address.getPatientId());
        System.out.println("ACTUALIZANDO");
        System.out.println(singleton.getId());
        patienteService service  = retrofit.create(patienteService.class);

        Call<Void> RequestCall = service.editarDireccion(singleton.getId(),address);

        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Log.e("API actualizar info",response.message());

                if(response.code() == 200){

                    System.out.println("ACTUALIZADO CORRECTAMENTE");
                    provincia.setEnabled(false);
                    canton.setEnabled(false);
                    distrito.setEnabled(false);
                    otros.setEnabled(false);
                }else{


                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("error----->"+t.getMessage());
            }
        });


    }

    private void initComponents(){
        nombre = findViewById(R.id.userName);
        apellido = findViewById(R.id.apellido);
        edad  = findViewById(R.id.userAge);

        tipoSangre = findViewById(R.id.blood);
        estadoCivil = findViewById(R.id.maritalStatus);
        telefono = findViewById(R.id.phone);

        provincia = findViewById(R.id.province);
        canton = findViewById(R.id.canton);
        distrito = findViewById(R.id.distrito);
        otros = findViewById(R.id.idsennas);

    }
}

