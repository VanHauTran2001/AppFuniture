package com.example.appfuniture.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfuniture.Model.Popular;
import com.example.appfuniture.databinding.ItemPhoBienBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class PhoBienAdapter extends RecyclerView.Adapter<PhoBienAdapter.PhoBienViewHolder> {
    private IPopular iPopular;

    public PhoBienAdapter(IPopular iPopular) {
        this.iPopular = iPopular;
    }

    @NonNull
    @Override
    public PhoBienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhoBienBinding binding = ItemPhoBienBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PhoBienViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhoBienViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Popular popular = iPopular.getListPopular(position);
        holder.binding.namePopular.setText(popular.getNamePopular());
        holder.binding.imagePopular.setImageResource(popular.getImgPopular());
        holder.binding.rating.setRating(popular.getRating());
        holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(popular.getMoneyPopular()) +" vnd");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iPopular.onClickItemPopular(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return iPopular.getCountPopular();
    }

    public interface IPopular{
        int getCountPopular();
        Popular getListPopular(int position);
        void onClickItemPopular(int position);
    }
    public class PhoBienViewHolder extends RecyclerView.ViewHolder{
        ItemPhoBienBinding binding;
        public PhoBienViewHolder(@NonNull ItemPhoBienBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
