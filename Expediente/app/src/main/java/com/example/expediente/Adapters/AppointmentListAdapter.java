package com.example.expediente.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.expediente.Models.PatientAppointment;
import com.example.expediente.R;

import java.util.ArrayList;
import java.util.List;

public class AppointmentListAdapter extends RecyclerView.Adapter<ItemAppointmentHolder> {

    private List<PatientAppointment> dataset;
    private AppointmentListAdapter.RecyclerViewClickListener listener;
    private Context context;
    //constructor
    public AppointmentListAdapter(ArrayList<PatientAppointment> dataset) {
        this.dataset = dataset;
    }

    public AppointmentListAdapter(Context context, AppointmentListAdapter.RecyclerViewClickListener listener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ItemAppointmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View list_view = inflater.inflate(R.layout.item_appointment,parent, false);//se pone false porque no es lo unico que va a estar en la pantalla
        ItemAppointmentHolder itemviewHolder = new ItemAppointmentHolder(list_view,listener);

        return itemviewHolder;

    }

    @Override
    public void onBindViewHolder( ItemAppointmentHolder holder, int position) {
        final PatientAppointment p = dataset.get(position);
        try {

            holder.app_day.setText(p.getDrAppDay());
            holder.app_hour.setText(p.getDrAppHour());
            holder.app_center.setText(p.getCenter().getCenterName());
            Glide.with(context).load(R.drawable.ic_appointment)
                    .centerCrop()
                    .transition(new DrawableTransitionOptions().crossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.app_icon);
        }catch (Exception e){
            System.out.println("error-->"+e);
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addAppointment(List<PatientAppointment> list) {
        this.dataset.addAll(list);//le setea la info de lalista

        notifyDataSetChanged();//se actualizara el recycler view en pantalla
    }


    public interface RecyclerViewClickListener{

        void OnClick(View v, int adapterPosition);
    }

}


