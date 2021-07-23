package com.example.expediente;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.expediente.Models.Address;
import com.example.expediente.Models.Details;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.servicesAPI.patienteService;

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
        initButtons();
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

            guargarInfo();

        });

        GuardarAddress.setOnClickListener(v->{

            guargarDireccion();

        });
    }

    private void guargarInfo() {

        Details details  = new Details();
        details.setPatientId(singleton.getId());
        details.setBloodType(tipoSangre.toString());
        details.setPhone(telefono.toString());
        details.setMaritalStatus(estadoCivil.toString());
        patienteService service  = retrofit.create(patienteService.class);

        Call<Void> RequestCall = service.editarInformacion(estadoCivil.toString(),telefono.toString(),singleton.getId());

        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {


                if(response.code() == 200){

                    System.out.println("ACTUALIZADO CORRECTAMENTE");

                }else{


                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }//fin guardarInfo

    private void guargarDireccion() {

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
//        System.out.println("ACTUALIZANDO");
        patienteService service  = retrofit.create(patienteService.class);

        Call<Void> RequestCall = service.editarDireccion(address,singleton.getId());

        RequestCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {


                if(response.code() == 200){

                    System.out.println("ACTUALIZADO CORRECTAMENTE");

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

             provincia.setText(getIntent().getStringExtra("Province"));
            canton.setText(getIntent().getStringExtra("Canton"));
            distrito.setText(getIntent().getStringExtra("Distrito"));
            otros.setText(getIntent().getStringExtra("OS"));

            tipoSangre.setText("Tipo Sangre: "+getIntent().getStringExtra("BT"));
            estadoCivil.setText(getIntent().getStringExtra("MS"));
            telefono.setText(getIntent().getStringExtra("Phone"));

            nombre.setText(getIntent().getStringExtra("userName"));
            apellido.setText(getIntent().getStringExtra("LastName"));
            edad.setText(getIntent().getStringExtra("Age"));

    }
}

