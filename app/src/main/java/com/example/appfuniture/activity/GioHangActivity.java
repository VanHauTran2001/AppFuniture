package com.example.appfuniture.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.appfuniture.R;
import com.example.appfuniture.databinding.ActivityGioHangBinding;

public class GioHangActivity extends AppCompatActivity {
    private ActivityGioHangBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_gio_hang);
    }
}