package com.example.expediente;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VaccineInfo extends AppCompatActivity {

    TextView nombre;
    TextView dia_app;
    TextView sgt_app;
    TextView razones;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_info);
        initInfo();
    }

    private void initInfo(){
    nombre = findViewById(R.id.id_nombre);
    dia_app= findViewById(R.id.id_app_day);
    sgt_app = findViewById(R.id.id_sg_app);
    razones = findViewById(R.id.razones);

    String name = getIntent().getStringExtra("nombre");
    String dia = getIntent().getStringExtra("diaApp");
    String sgt = getIntent().getStringExtra("sgtApp");
    String r = getIntent().getStringExtra("razones");

    nombre.setText(name);
    dia_app.setText(dia);
    sgt_app.setText(sgt);
    razones.setText(r);


    }//init informacion
}
