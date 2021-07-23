package com.example.expediente;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AllergyInfo extends AppCompatActivity {

    TextView nombre;
    TextView diagnostico;
    TextView meds;
    TextView detalles;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_info);
        initInfo();
    }

    private void initInfo(){
        nombre = findViewById(R.id.nombreallergia);
        diagnostico= findViewById(R.id.diagnostico);
        meds = findViewById(R.id.medicamentos);
        detalles = findViewById(R.id.detalles);

        String name = getIntent().getStringExtra("nombre");
        String dia = getIntent().getStringExtra("diagnostico");
        String medic = getIntent().getStringExtra("meds");
        String r = getIntent().getStringExtra("detalles");

        nombre.setText(name);
        diagnostico.setText(dia);
        meds.setText(medic);
        detalles.setText(r);


    }//init informacion

}
