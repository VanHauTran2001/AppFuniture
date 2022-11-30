package com.example.appfuniture.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.appfuniture.Model.User;
import com.example.appfuniture.R;
import com.example.appfuniture.SQLite.SQLiteHelper;
import com.example.appfuniture.Utils.Util;
import com.example.appfuniture.databinding.ActivitySigninBinding;

import java.util.ArrayList;

public class SigninActivity extends AppCompatActivity {
    private ActivitySigninBinding binding;
    private SQLiteHelper sqLiteHelper;
    private ArrayList<User> userArrayList;
    private boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_signin);
        initSQLite();
        userArrayList = new ArrayList<>();
        //Lấy dữ liệu từ bảng User sau đó add vào list
        Cursor cursor = sqLiteHelper.getData("SELECT * FROM User");
        while (cursor.moveToNext()) {
            String phoneNumber = cursor.getString(1);
            userArrayList.add(new User(phoneNumber));
        }
        customBtnDangKy();
        customBtnDangNhap();

    }



    private void customBtnDangKy() {
        binding.txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this,SignupActivity.class));
            }
        });
    }

    private void customBtnDangNhap() {
        binding.btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = binding.edtPhone.getText().toString().trim();
                //Kiểm tra số điện thoại của người dùng nhập và số điện thoại đăng ký nếu giống nhau thì đăng nhập thành công
                for(int i=0;i<userArrayList.size();i++){
                    if (phone.equals(userArrayList.get(i).getPhone())){
                        check = true;
                    }else {
                        check = false;
                    }
                }
                if (check){
                    Toast.makeText(SigninActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SigninActivity.this, MainActivity.class));
                }
                else {
                    Toast.makeText(SigninActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initSQLite() {
        //Tạo bảng
        sqLiteHelper = new SQLiteHelper(SigninActivity.this,"Database.sqlite",null,1);
        sqLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS User(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Phone VARCHAR(100))");
    }
}