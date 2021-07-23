package com.example.expediente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expediente.Adapters.AllergyListAdapter;
import com.example.expediente.Models.PatientAllergy;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.servicesAPI.allergyService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Allergies extends AppCompatActivity {

    private RecyclerView ListRecycler;//apunta al elemento con el que quiero trabajar en el view
    private Retrofit retrofit;
    private AllergyListAdapter ListA;
    TextView listaVacia;
    List<PatientAllergy> jojo;
    private AllergyListAdapter.RecyclerViewClickListener listener;
    PatientSingleton singleton = PatientSingleton.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);
        setOnClickListener();
        ListA = new AllergyListAdapter(this,listener);
        listaVacia = findViewById(R.id.lista_alergias);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListRecycler = findViewById(R.id.allergyRecyclerView);
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

        allergyService service  = retrofit.create(allergyService.class);
        Call<List<PatientAllergy>> RequestCall = service.obtainAllergies(singleton.getId());

        RequestCall.enqueue(new Callback<List<PatientAllergy>>() {



            @Override
            public void onResponse(Call<List<PatientAllergy>> call, Response<List<PatientAllergy>> response) {
                if(response.isSuccessful()) {//si la respuesta es existosa
                    List<PatientAllergy> list = response.body();

                    jojo = list;
                    if(list.isEmpty()){
                        listaVacia.setVisibility(View.VISIBLE);
                    }
                    ListA.addAllergies(new ArrayList(list));

                    ListA.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<List<PatientAllergy>> call, Throwable t) {

                System.out.println("OnFailure ---->"+t.getMessage());
            }
        });

    }//fin obtener las vacunas

    private void setOnClickListener() {
        listener = new AllergyListAdapter.RecyclerViewClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),AllergyInfo.class);
                intent.putExtra("nombre",jojo.get(position).getAllergy().getAllergyName());
                intent.putExtra("diagnostico",jojo.get(position).getDiagnosticDate());
                intent.putExtra("meds",jojo.get(position).getMedication());
                intent.putExtra("detalles",jojo.get(position).getReasons());
                startActivity(intent);
            }//se envia el nuevo activity al darle click a nuestro objeto
        };
    }
}
