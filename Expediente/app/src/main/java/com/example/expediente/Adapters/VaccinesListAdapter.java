package com.example.expediente.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.expediente.Models.PatientVaccine;
import com.example.expediente.R;

import java.util.ArrayList;
import java.util.List;

public class VaccinesListAdapter extends RecyclerView.Adapter<ItemVaccineviewHolder> {

    private List<PatientVaccine> dataset;
    private VaccinesListAdapter.RecyclerViewClickListener listener;
    private Context context;
    //constructor
    public VaccinesListAdapter(ArrayList<PatientVaccine> dataset) {
        this.dataset = dataset;
    }

    public VaccinesListAdapter(Context context, RecyclerViewClickListener listener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ItemVaccineviewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View list_view = inflater.inflate(R.layout.item_vaccine,parent, false);//se pone false porque no es lo unico que va a estar en la pantalla
        ItemVaccineviewHolder itemviewHolder = new ItemVaccineviewHolder(list_view,listener);

        return itemviewHolder;

    }

    @Override
    public void onBindViewHolder( ItemVaccineviewHolder holder, int position) {

       final PatientVaccine p = dataset.get(position);
       try {
           System.out.println("hi desde onbind");
           holder.vaccine_name.setText(p.getVaccine().getVaccineName());
           holder.vaccine_day.setText(p.getvAppDate());
           Glide.with(context).load(R.drawable.ic_vaccine)
                   .centerCrop()
                   .transition(new DrawableTransitionOptions().crossFade())
                   .diskCacheStrategy(DiskCacheStrategy.ALL)
                   .into(holder.vaccine_icon);
       }catch (Exception e){
           System.out.println("error-->"+e);
       }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addVaccines(List<PatientVaccine> list) {
        this.dataset.addAll(list);//le setea la info de lalista
        System.out.println("---------data set has vaccines--------------");
        for (int i = 0; i < dataset.size(); i++) {
            System.out.println(dataset.get(i).getVaccine().getVaccineName());
        }
        notifyDataSetChanged();//se actualizara el recycler view en pantalla
    }


    public interface RecyclerViewClickListener{

        void OnClick(View v, int adapterPosition);
    }
}
