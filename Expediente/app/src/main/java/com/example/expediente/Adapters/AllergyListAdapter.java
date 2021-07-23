package com.example.expediente.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.expediente.Models.PatientAllergy;
import com.example.expediente.R;

import java.util.ArrayList;
import java.util.List;

public class AllergyListAdapter  extends RecyclerView.Adapter<ItemAllergyHolder>  {

    private List<PatientAllergy> dataset;
    private AllergyListAdapter.RecyclerViewClickListener listener;
    private Context context;
    //constructor
    public AllergyListAdapter(ArrayList<PatientAllergy> dataset) {
        this.dataset = dataset;
    }

    public AllergyListAdapter(Context context, AllergyListAdapter.RecyclerViewClickListener listener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ItemAllergyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View list_view = inflater.inflate(R.layout.item_allergy,parent, false);//se pone false porque no es lo unico que va a estar en la pantalla
        ItemAllergyHolder itemviewHolder = new ItemAllergyHolder(list_view,listener);

        return itemviewHolder;

    }

    @Override
    public void onBindViewHolder( ItemAllergyHolder holder, int position) {
        final PatientAllergy p = dataset.get(position);
        try {

            holder.allergy_name.setText(p.getAllergy().getAllergyName());
            holder.diagnostic_day.setText(p.getDiagnosticDate());
            Glide.with(context).load(R.drawable.ic_smallpox)
                    .centerCrop()
                    .transition(new DrawableTransitionOptions().crossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.allergy_icon);
        }catch (Exception e){
            System.out.println("error-->"+e);
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addAllergies(List<PatientAllergy> list) {
        this.dataset.addAll(list);//le setea la info de lalista

        notifyDataSetChanged();//se actualizara el recycler view en pantalla
    }


    public interface RecyclerViewClickListener{

        void OnClick(View v, int adapterPosition);
    }
}
