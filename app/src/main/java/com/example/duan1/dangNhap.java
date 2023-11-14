package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.DAO.nguoiDungDAO;
import com.google.android.material.textfield.TextInputEditText;

public class dangNhap extends AppCompatActivity {
    TextView tv_dangKy;

    Button btn_login;

    TextInputEditText username, password;

    nguoiDungDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        mipMap();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        tv_dangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dangNhap.this, dangKy.class));
                finish();
            }
        });



    }


    private void mipMap(){
        tv_dangKy = findViewById(R.id.tv_dangKy);
        btn_login = findViewById(R.id.btn_login);
        username = findViewById(R.id.edt_lg_Username);
        password = findViewById(R.id.edt_lg_Password);
    }

    private  void Login(){

        String user = username.getText().toString();
        String pass = password.getText().toString();
        if(user.equals("")||pass.equals("")){
            Toast.makeText(dangNhap.this, "can nhap du lieu", Toast.LENGTH_SHORT).show();
        }else{
            nguoiDungDAO = new nguoiDungDAO(this);
            if(nguoiDungDAO.checkUserPass(user, pass)){


                startActivity(new Intent(dangNhap.this, manHinhChinh.class));
                finish();
            }else{
                Toast.makeText(this, "user va mat khau khong dung", Toast.LENGTH_SHORT).show();
            }
        }
    }
}