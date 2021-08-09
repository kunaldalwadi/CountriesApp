package com.example.countriesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.countriesapp.R;
import com.example.countriesapp.model.CatFacts;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.FactsViewHolder> {
    
    private ArrayList<CatFacts> mCatFacts;
    
    public FactsAdapter(ArrayList<CatFacts> catFacts) {
        mCatFacts = catFacts;
    }
    
    @NonNull
    @Override
    public FactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.facts_list_row,parent,false);
        
        return new FactsViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull FactsViewHolder holder, int position) {
    
        holder.tv_facts.setText(mCatFacts.get(position).getFact());
        
    }
    
    @Override
    public int getItemCount() {
        return 0;
    }
    
    class FactsViewHolder extends RecyclerView.ViewHolder{
    
        TextView tv_facts;
        
        public FactsViewHolder(@NonNull View itemView) {
            super(itemView);
            
            tv_facts = itemView.findViewById(R.id.tv_fact);
            
        }
    }
}
