package com.example.expediente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expediente.Adapters.VaccinesListAdapter;
import com.example.expediente.Models.PatientSingleton;
import com.example.expediente.Models.PatientVaccine;
import com.example.expediente.servicesAPI.vaccineService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Vaccines  extends AppCompatActivity {



    private RecyclerView ListRecycler;//apunta al elemento con el que quiero trabajar en el view
    private Retrofit retrofit;
    private VaccinesListAdapter ListA;
    TextView lista;
     List<PatientVaccine> jojo;
    private VaccinesListAdapter.RecyclerViewClickListener listener;
    PatientSingleton singleton = PatientSingleton.getInstance();
    //int vacio

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        setOnClickListener();
        ListA = new VaccinesListAdapter(this,listener);
        lista = findViewById(R.id.lista_vacia);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListRecycler = findViewById(R.id.vaccinesRecyclerView);
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
        List<PatientVaccine> vacunas = new ArrayList<>();
        vaccineService service  = retrofit.create(vaccineService.class);
        Call<List<PatientVaccine>> RequestCall = service.obtainVaccines(singleton.getId());

        RequestCall.enqueue(new Callback<List<PatientVaccine>>() {



            @Override
            public void onResponse(Call<List<PatientVaccine>> call, Response<List<PatientVaccine>> response) {
                if(response.isSuccessful()) {//si la respuesta es existosa
                    List<PatientVaccine> list = response.body();

                    jojo = list;
                    if(list.isEmpty()){

                        System.out.println("esta vacia");
                        lista.setVisibility(View.VISIBLE);
                    }
                    ListA.addVaccines(new ArrayList(list));

                    ListA.notifyDataSetChanged();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getVaccine().getVaccineName());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<PatientVaccine>> call, Throwable t) {

                System.out.println("OnFailure ---->"+t.getMessage());
            }
        });

    }//fin obtener las vacunas

    private void setOnClickListener() {
        listener = new VaccinesListAdapter.RecyclerViewClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),VaccineInfo.class);
                intent.putExtra("nombre",jojo.get(position).getVaccine().getVaccineName() );
                intent.putExtra("diaApp",jojo.get(position).getvAppDate());
                intent.putExtra("sgtApp",jojo.get(position).getNextAppDate());
                intent.putExtra("razones",jojo.get(position).getReasons().toString());
                startActivity(intent);
            }//se envia el nuevo activity al darle click a nuestro objeto
        };
    }
}
