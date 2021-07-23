package com.example.expediente;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AppointmentInfo extends AppCompatActivity {

    TextView dia;
    TextView hora;
    TextView especialidad;
    TextView detalles;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        initInfo();
    }

    private void initInfo(){
        dia = findViewById(R.id.id_day);
        hora= findViewById(R.id.id_hora);
        especialidad = findViewById(R.id.especialidad);
        detalles = findViewById(R.id.id_details2);

        String dia_cita = getIntent().getStringExtra("dia");
        String hora_cita = getIntent().getStringExtra("hora");
        String especialidad_cita = getIntent().getStringExtra("especialidad");
        String r = getIntent().getStringExtra("details");

        dia.setText(dia_cita);
        hora.setText(hora_cita);
        especialidad.setText(especialidad_cita);
        detalles.setText(r);


    }//init informacion
}
