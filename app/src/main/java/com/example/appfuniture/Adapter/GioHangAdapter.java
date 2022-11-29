package com.example.appfuniture.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfuniture.Model.GioHang;
import com.example.appfuniture.Utils.Util;
import com.example.appfuniture.activity.GioHangActivity;
import com.example.appfuniture.databinding.ItemGioHangBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.GioHangViewHolder> {
    private IGioHang iGioHang;

    public GioHangAdapter(IGioHang iGioHang) {
        this.iGioHang = iGioHang;
    }

    @NonNull
    @Override
    public GioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGioHangBinding binding = ItemGioHangBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new GioHangViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GioHangViewHolder holder, @SuppressLint("RecyclerView") int position) {
        GioHang gioHang = iGioHang.getListGioHang(position);
        holder.binding.imgGioHang.setImageResource(gioHang.getImgGioHang());
        holder.binding.nameDetails.setText(gioHang.getTenSP());
        holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(gioHang.getGiaSp()) +" vnd");
        holder.binding.txtNumber.setText(""+gioHang.getSoLuongSP());
        holder.binding.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuongMoi = Integer.parseInt(holder.binding.txtNumber.getText().toString())+1;
                holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                int slHienTai = Util.gioHangArrayList.get(position).getSoLuongSP();
                int giaHienTai = Util.gioHangArrayList.get(position).getGiaSp();
                Util.gioHangArrayList.get(position).setSoLuongSP(soLuongMoi);
                double giaMoi = (soLuongMoi*giaHienTai)/slHienTai;
                Util.gioHangArrayList.get(position).setGiaSp((int) giaMoi);
                holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(giaMoi) +" vnd");
                GioHangActivity.EvenChangeUtil();
            }
        });
        holder.binding.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuongMoi = Integer.parseInt(holder.binding.txtNumber.getText().toString())-1;
                holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                int slHienTai = Util.gioHangArrayList.get(position).getSoLuongSP();
                int giaHienTai = Util.gioHangArrayList.get(position).getGiaSp();
                Util.gioHangArrayList.get(position).setSoLuongSP(soLuongMoi);
                double giaMoi = (soLuongMoi*giaHienTai)/slHienTai;
                Util.gioHangArrayList.get(position).setGiaSp((int) giaMoi);
                holder.binding.txtMoneyPopular.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(giaMoi) +" vnd");
                GioHangActivity.EvenChangeUtil();
                if (soLuongMoi<2){
                    holder.binding.btnTru.setVisibility(View.GONE);
                    holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                }else {
                    holder.binding.btnTru.setVisibility(View.VISIBLE);
                    holder.binding.txtNumber.setText(String.valueOf(soLuongMoi));
                }
            }
        });
        holder.binding.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.gioHangArrayList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                GioHangActivity.EvenChangeUtil();
            }
        });
    }

    @Override
    public int getItemCount() {
        return iGioHang.getCount();
    }

    public interface IGioHang{
        int getCount();
        GioHang getListGioHang(int position);
    }
    public class GioHangViewHolder extends RecyclerView.ViewHolder{
        private ItemGioHangBinding binding;
        public GioHangViewHolder(@NonNull ItemGioHangBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
