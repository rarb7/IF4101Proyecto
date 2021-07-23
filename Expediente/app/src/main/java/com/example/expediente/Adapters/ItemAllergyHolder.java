package com.example.expediente.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.expediente.R;

public class ItemAllergyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView allergy_icon;
    TextView allergy_name;
    TextView  diagnostic_day;
    private AllergyListAdapter.RecyclerViewClickListener listener;

    public ItemAllergyHolder( View itemView, AllergyListAdapter.RecyclerViewClickListener listener) {
        super(itemView);

        this.listener = listener;
        allergy_name = itemView.findViewById(R.id.allergyName);
        diagnostic_day = itemView.findViewById(R.id.diagnostic_day);

        allergy_icon = itemView.findViewById(R.id.app_ico);

        itemView.setOnClickListener(this);
    }//constructor

    @Override
    public void onClick(View v) {
        listener.OnClick(v,getAdapterPosition());
    }


}
