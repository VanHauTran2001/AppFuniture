package com.example.appfuniture.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appfuniture.Adapter.CategoryAdapter;
import com.example.appfuniture.Adapter.GioHangAdapter;
import com.example.appfuniture.Model.GioHang;
import com.example.appfuniture.R;
import com.example.appfuniture.Utils.Util;
import com.example.appfuniture.databinding.ActivityGioHangBinding;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GioHangActivity extends AppCompatActivity implements GioHangAdapter.IGioHang {
    private static ActivityGioHangBinding binding;
    private static GioHangAdapter adapter;
    int slMua = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_gio_hang);
        adapter = new GioHangAdapter(this);
        initRecylerViewGioHang();
        onClickBack();
        EvenChangeUtil();
        onClickMuaHang();
    }

    private void onClickMuaHang() {
        binding.linearMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khi click mua hàng thì sẽ truyền số lượng sang màn hình thanh toán
                Intent intent = new Intent(GioHangActivity.this,ThanhToanActivity.class);
                int sl = Integer.parseInt(binding.txtSoLuongMuaHang.getText().toString().trim());
                intent.putExtra("soluong",sl);
                startActivity(intent);
            }
        });
    }

    public static void EvenChangeUtil() {
        //Hàm tính tổng tiền và số lượng mua hàng . Khi tăng giảm thì tiền và số lượng cũng thay đổi ngay sau đó
        int tongTien = 0;
        int sl = 0;
        for (int i=0;i<Util.gioHangArrayList.size();i++){
            tongTien+= Util.gioHangArrayList.get(i).getGiaSp();
            sl += Util.gioHangArrayList.get(i).getSoLuongSP();
        }
        binding.txtSoLuongSP.setText("("+sl+")");
        binding.txtSoLuongMuaHang.setText(sl+"");
        binding.txtTongTienThanhToan.setText("vnd "+NumberFormat.getNumberInstance(Locale.getDefault()).format(tongTien));
    }

    private void initRecylerViewGioHang() {
        //khởi tạo adapter và hiển thị dữ liệu lên recyclerView
        adapter = new GioHangAdapter(this);
        binding.recylerGioHang.setLayoutManager(new LinearLayoutManager(this));
        binding.recylerGioHang.setAdapter(adapter);
    }

    private void onClickBack() {
        //Nút back quay lại màn hình cũ
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }

    @Override
    public int getCount() {
        //hàm trả về số lượng của list giỏ hàng
        if (Util.gioHangArrayList==null){
            return 0;
        }
        return Util.gioHangArrayList.size();
    }

    @Override
    public GioHang getListGioHang(int position) {
        return Util.gioHangArrayList.get(position);
    }
}