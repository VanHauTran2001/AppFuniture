package com.example.appfuniture.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appfuniture.Model.GiamGia;
import com.example.appfuniture.databinding.ItemGiamGiaBinding;

public class GiamGiaAdapter extends RecyclerView.Adapter<GiamGiaAdapter.GiamGiaViewHolder>{
    private ISale iSale;

    public GiamGiaAdapter(ISale iSale) {
        this.iSale = iSale;
    }

    @NonNull
    @Override
    public GiamGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGiamGiaBinding binding = ItemGiamGiaBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new GiamGiaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GiamGiaViewHolder holder, int position) {
        GiamGia sales = iSale.getListSale(position);
        holder.binding.txtGiamGia.setText("-"+sales.getNumberSale()+"%");
        holder.binding.txtGiaGoc.setText(sales.getGiaTienBanDau()+" vnd");
        holder.binding.txtGiaSale.setText(sales.getGiaTienSale()+" vnd");
        holder.binding.txtDaBan.setText("Đã bán "+sales.getDaBan());
        holder.binding.imageItem.setImageResource(sales.getImageSale());
    }

    @Override
    public int getItemCount() {
        return iSale.getCount();
    }

    public interface ISale{
        int getCount();
        GiamGia getListSale(int position);
    }
    public class GiamGiaViewHolder extends RecyclerView.ViewHolder{
        private ItemGiamGiaBinding binding;
        public GiamGiaViewHolder(@NonNull ItemGiamGiaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
