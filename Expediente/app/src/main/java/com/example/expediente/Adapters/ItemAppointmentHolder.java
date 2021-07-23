package com.example.expediente.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.expediente.R;

public class ItemAppointmentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView app_icon;
    TextView app_day;
    TextView  app_hour;
    TextView  app_center;
    private AppointmentListAdapter.RecyclerViewClickListener listener;

    public ItemAppointmentHolder( View itemView, AppointmentListAdapter.RecyclerViewClickListener listener) {
        super(itemView);

        this.listener = listener;
        app_day = itemView.findViewById(R.id.appDay);
        app_hour = itemView.findViewById(R.id.appHour);
        app_center = itemView.findViewById(R.id.id_center);
        app_icon = itemView.findViewById(R.id.app_ico);

        itemView.setOnClickListener(this);
    }//constructor

    @Override
    public void onClick(View v) {
        listener.OnClick(v,getAdapterPosition());
    }


}
