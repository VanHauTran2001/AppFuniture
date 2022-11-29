package com.example.appfuniture.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appfuniture.Model.Popular;
import com.example.appfuniture.R;
import com.example.appfuniture.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private Popular popular;
    private int numberOder = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        onShowData();
        onBack();
        customNumberOder();
    }

    private void customNumberOder() {
        binding.btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOder = numberOder+1;
                binding.txtNumber.setText(String.valueOf(numberOder));
            }
        });
        binding.btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOder>1){
                    numberOder =numberOder-1;
                }
                binding.txtNumber.setText(String.valueOf(numberOder));
            }
        });
    }

    private void onBack() {
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void onShowData() {
        Intent intent = getIntent();
        popular = (Popular) intent.getSerializableExtra("popular");
        binding.nameDetails.setText(popular.getNamePopular());
        binding.imgDetails.setImageResource(popular.getImgPopular());
        binding.txtMoneyPopular.setText(popular.getMoneyPopular()+"vnd");
    }
}