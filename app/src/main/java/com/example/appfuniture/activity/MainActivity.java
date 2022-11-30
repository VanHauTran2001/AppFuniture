package com.example.appfuniture.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.appfuniture.Adapter.CategoryAdapter;
import com.example.appfuniture.Adapter.GiamGiaAdapter;
import com.example.appfuniture.Adapter.PhoBienAdapter;
import com.example.appfuniture.Adapter.ViewPagerAdapter;
import com.example.appfuniture.Model.Category;
import com.example.appfuniture.Model.GiamGia;
import com.example.appfuniture.Model.Pager;
import com.example.appfuniture.Model.Popular;
import com.example.appfuniture.R;
import com.example.appfuniture.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.iCategory, GiamGiaAdapter.ISale, PhoBienAdapter.IPopular {
    private ActivityMainBinding binding;
    int current;
    Runnable runnable;
    private ArrayList<Category> categoryArrayList;
    private ArrayList<GiamGia> giamGiaArrayList;
    private ArrayList<Popular> phoBienArrayList;
    private CategoryAdapter categoryAdapter;
    private GiamGiaAdapter giamGiaAdapter;
    private PhoBienAdapter phoBienAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        categoryArrayList = new ArrayList<>();
        giamGiaArrayList = new ArrayList<>();
        phoBienArrayList = new ArrayList<>();
        customViewFliper();
        addDataCategory();
        addDataGiamGia();
        addDataPhoBien();
        initRecylerCategory();
        intiReclerGiamGia();
        initRecylerPhoBien();
        onClickSearch();
    }

    private void onClickSearch() {
        binding.edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });
    }

    private void initRecylerPhoBien() {
        phoBienAdapter = new PhoBienAdapter(this);
        binding.recylerPhoBien.setLayoutManager(new GridLayoutManager(this,2));
        binding.recylerPhoBien.setAdapter(phoBienAdapter);
    }

    private void addDataPhoBien() {
        phoBienArrayList.add(new Popular("Ghế xoay",R.drawable.ghe2,5,2610000));
        phoBienArrayList.add(new Popular("Ghế Bành",R.drawable.ghe3,5,3610000));
        phoBienArrayList.add(new Popular("Sofa LINNAS",R.drawable.sofa1, 4.5f,4610000));
        phoBienArrayList.add(new Popular("Tủ PAX",R.drawable.tu,3.5f,5610000));
        phoBienArrayList.add(new Popular("Đèn HEKTAR",R.drawable.den,5,8610000));
        phoBienArrayList.add(new Popular("Ghế sofa",R.drawable.ghe4,5,7610000));
    }

    private void addDataCategory() {
        categoryArrayList.add(new Category("Ghế"));
        categoryArrayList.add(new Category("Sofa"));
        categoryArrayList.add(new Category("Bàn"));
        categoryArrayList.add(new Category("Tủ"));
        categoryArrayList.add(new Category("Đèn"));
    }
    private void addDataGiamGia(){
        giamGiaArrayList.add(new GiamGia(30,R.drawable.ghe1,"5.852.000","4.096.000",25));
        giamGiaArrayList.add(new GiamGia(27,R.drawable.sofa1,"5.852.000","4.096.000",11));
        giamGiaArrayList.add(new GiamGia(32,R.drawable.giuong1,"5.852.000","4.096.000",22));
        giamGiaArrayList.add(new GiamGia(25,R.drawable.ghe2,"5.852.000","4.096.000",27));
        giamGiaArrayList.add(new GiamGia(50,R.drawable.ghe3,"5.852.000","4.096.000",35));
        giamGiaArrayList.add(new GiamGia(10,R.drawable.giuong2,"5.852.000","4.096.000",45));
    }

    private void intiReclerGiamGia() {
        giamGiaAdapter = new GiamGiaAdapter(this);
        binding.recylerGiamGia.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recylerGiamGia.setAdapter(giamGiaAdapter);
    }

    private void initRecylerCategory() {
        categoryAdapter = new CategoryAdapter(this);
        binding.recycLerMenu.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recycLerMenu.setAdapter(categoryAdapter);
    }

    private void customViewFliper() {
        ArrayList<Pager> pagerArrayList = new ArrayList<>();
        pagerArrayList.add(new Pager("https://img.pikbest.com/backgrounds/20210507/real-furniture-sofa-business-advertising-discount-banner-template_5944214.jpg!bwr800"));
        pagerArrayList.add(new Pager("https://admin.mhomedecor.com.vn/storage/media/v7dglvfPocxYNNrEbDGheXAHPSiw9teN6IR1CkDD.jpg"));
        pagerArrayList.add(new Pager("https://znews-photo.zingcdn.me/w660/Uploaded/wyhktpu/2021_05_07/200902_Styler_Banner_LivingRoom_Black_2.jpg"));
        pagerArrayList.add(new Pager("https://media.shoptretho.com.vn/upload/image/news/20221005/post-f.png"));
        pagerArrayList.add(new Pager("https://image.shutterstock.com/image-vector/modern-flat-furniture-concept-banner-260nw-1596871756.jpg"));
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(pagerArrayList);
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.circleIndicator.setViewPager(binding.viewPager);
        Handler handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                current =binding.viewPager.getCurrentItem();
                current++;
                if (current>=binding.viewPager.getAdapter().getCount()){
                    current =0;
                }
                binding.viewPager.setCurrentItem(current,true);
                handler.postDelayed(runnable,4000);
            }
        };
        handler.postDelayed(runnable,4000);
    }

    @Override
    public int getCountCategory() {
        return categoryArrayList.size();
    }

    @Override
    public Category getIemCategory(int position) {
        return categoryArrayList.get(position);
    }

    @Override
    public int getCount() {
        return giamGiaArrayList.size();
    }

    @Override
    public GiamGia getListSale(int position) {
        return giamGiaArrayList.get(position);
    }

    @Override
    public int getCountPopular() {
        return phoBienArrayList.size();
    }

    @Override
    public Popular getListPopular(int position) {
        return phoBienArrayList.get(position);
    }

    @Override
    public void onClickItemPopular(int position) {
        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        Popular popular = phoBienArrayList.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("popular",popular);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}