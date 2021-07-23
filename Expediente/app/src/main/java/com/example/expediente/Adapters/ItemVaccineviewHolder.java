package com.example.expediente.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.expediente.R;


public class ItemVaccineviewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView vaccine_icon;
    TextView  vaccine_name;
    TextView  vaccine_day;
   private VaccinesListAdapter.RecyclerViewClickListener listener;

    public ItemVaccineviewHolder( View itemView, VaccinesListAdapter.RecyclerViewClickListener listener) {
        super(itemView);
        System.out.println("---hi desde item Vaccine HOlder");
        this.listener = listener;
         vaccine_name = itemView.findViewById(R.id.vaccineName);
          vaccine_day = itemView.findViewById(R.id.diagnostic_day);
        //se linke con el view holder
      vaccine_icon = itemView.findViewById(R.id.app_ico);

        itemView.setOnClickListener(this);
    }//constructor

    @Override
    public void onClick(View v) {
        listener.OnClick(v,getAdapterPosition());
    }
}
