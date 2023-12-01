package com.example.duan1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.duan1.fragment.caNhan_Fragment;
import com.example.duan1.fragment.gioHang_Fragment;
import com.example.duan1.fragment.hoaDon_Fragment;
import com.example.duan1.fragment.lichSu_Fragment;
import com.example.duan1.fragment.trangChu_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class manHinhChinh extends AppCompatActivity {


    BottomNavigationView navigationView;
    FrameLayout frameLayout;

    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        bottomNav();

    }

    private void mipMap(){
        navigationView = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.frameLayout);
    }

    private  void bottomNav(){
        mipMap();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.trangChu){
                    fragment = new trangChu_Fragment();
                }else if(itemId == R.id.lichSu){
                    fragment = new lichSu_Fragment();
                }else if(itemId == R.id.gioHang){
                   fragment = new gioHang_Fragment();
                }else if(itemId == R.id.hoaDon){
                    fragment = new hoaDon_Fragment();
                }else if(itemId == R.id.caNhan){
                    fragment = new caNhan_Fragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();

                return true;
            }
        });


    }


}