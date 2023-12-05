package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.DAO.nguoiDungDAO;
import com.google.android.material.textfield.TextInputEditText;

public class dangNhap extends AppCompatActivity {
    TextView tv_dangKy, tv_changePass;

    Button btn_login;

    TextInputEditText username, password;

    nguoiDungDAO nguoiDungDAO;

    CheckBox chk_rememberMe;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        mipMap();
        setPassUser();

        tv_changePass.setOnClickListener(v -> {
            startActivity(new Intent(dangNhap.this, changePass.class));
            finish();
        });

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
        tv_changePass = findViewById(R.id.tv_lg_changePass);
        chk_rememberMe = findViewById(R.id.chkRememberPass);
    }


    private void setPassUser(){
            sharedPreferences = getSharedPreferences("FILE", MODE_PRIVATE);
            String user = sharedPreferences.getString("ten", "");
            String pass = sharedPreferences.getString("pass", "");
            username.setText(user);
            password.setText(pass);

    }

    private  void Login(){

        String user = username.getText().toString();
        String pass = password.getText().toString();
        if(user.equals("")||pass.equals("")){
            Toast.makeText(dangNhap.this, "can nhap du lieu", Toast.LENGTH_SHORT).show();
        }else{
            nguoiDungDAO = new nguoiDungDAO(this);
            if(nguoiDungDAO.checkUserPass(user, pass)){
               if(chk_rememberMe.isChecked()){
                   sharedPreferences = getSharedPreferences("FILE", MODE_PRIVATE);
                   SharedPreferences.Editor editor = sharedPreferences.edit();
                   editor.putString("ten", user);
                   editor.putString("pass", pass);
                   editor.commit();
               }else{
                   // isCheck == false
                    sharedPreferences = getSharedPreferences("FILE", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("ten","");
                    editor.putString("pass","");
                    editor.commit();
               }
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(dangNhap.this, manHinhChinh.class));
                finish();
            }else{
                Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu sai !", Toast.LENGTH_SHORT).show();
            }
        }
    }
}