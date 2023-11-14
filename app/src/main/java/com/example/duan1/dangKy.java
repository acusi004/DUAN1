package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.duan1.DAO.nguoiDungDAO;
import com.google.android.material.textfield.TextInputEditText;

public class dangKy extends AppCompatActivity {

    Button btn_dangKy;
    nguoiDungDAO nguoiDungDAO;

    TextInputEditText edt_dky_username, edt_dky_password, edt_dky_Repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        btn_dangKy = findViewById(R.id.btn_dangKy);
        btn_dangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               signUp();
            }
        });

    }

    private void signUp(){
        edt_dky_username = findViewById(R.id.edt_signUp_Username);
        edt_dky_password = findViewById(R.id.edt_signUp_Password);
        edt_dky_Repassword = findViewById(R.id.edt_signUp_RePassword);

        nguoiDungDAO = new nguoiDungDAO(this);

        String user = edt_dky_username.getText().toString();
        String pass = edt_dky_password.getText().toString();
        String Repass = edt_dky_Repassword.getText().toString();

        if(user.equals("")||pass.equals("")||Repass.equals("")){
            Toast.makeText(this, "Can Nhap du lieu", Toast.LENGTH_SHORT).show();
        }else{
            if(pass.equals(Repass)){
                boolean checkuser = nguoiDungDAO.checkuser(user);
                if(checkuser == false){
                    boolean insert = nguoiDungDAO.InsertData(user, pass);
                    if(insert==true){
                        Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(dangKy.this, dangNhap.class));
                        finish();
                    }else{
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "tai khoan da ton tai", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "mat khau nhap lai sai", Toast.LENGTH_SHORT).show();
            }
        }

    }
}