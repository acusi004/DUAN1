package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.duan1.DAO.nguoiDungDAO;
import com.google.android.material.textfield.TextInputEditText;

public class changePass extends AppCompatActivity {

    Context context;
    TextInputEditText edt_Repass, edt_oldPass, edt_newPass;
    Button btn_changePass;
    nguoiDungDAO ndDAO;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        edt_Repass = findViewById(R.id.edt_rs_RePass);
        edt_oldPass = findViewById(R.id.edt_rs_oldPass);
        edt_newPass = findViewById(R.id.edt_rs_newPass);
        btn_changePass = findViewById(R.id.btn_changePass);
        ndDAO = new nguoiDungDAO(changePass.this);

        btn_changePass.setOnClickListener(v -> {
            UchangePass();
        });

    }

    public void UchangePass(){
        String oldPass =  edt_oldPass.getText().toString();
        String rePass = edt_Repass.getText().toString();
        String newPass = edt_newPass.getText().toString();

        if(oldPass.equals("")|| rePass.equals("")||newPass.equals("")){
            Toast.makeText(this, "Cần nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }else{
            if(rePass.equals(newPass)){
                sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);
                String ten = sharedPreferences.getString("TEN", "");


                boolean check = ndDAO.updatePassWord(ten,oldPass, newPass);

                if(check){
                    Toast.makeText(this, "Cập nhật thành công ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(changePass.this, dangNhap.class));
                    finish();
                }else{
                    Toast.makeText(this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Mật khẩu nhập lại sai", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean isChuoi(String str) {
        return str.matches("[a-zA-Z0-9]+");
    }
//    private boolean validate(String passWordOld, String passWordNew, String rePassWord) {
//        if (passWordOld.isEmpty() || passWordNew.isEmpty() || rePassWord.isEmpty()) {
//            Toast.makeText(this, "Vui lòng không bỏ trống", Toast.LENGTH_SHORT).show();
//            return false;
//        } else if (!isChuoi(passWordOld) || !isChuoi(passWordNew) || !isChuoi(rePassWord)) {
//            Toast.makeText(this, "Nhập sai định dạng", Toast.LENGTH_SHORT).show();
//            return false;
//        } else {
//            String pass_Old = sharedPreferences.getString("PASSWORD", "");
//            if (!passWordOld.equals(pass_Old)) {
//                Toast.makeText(getContext(), "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//            if (!passWordNew.equals(rePassWord)) {
//                Toast.makeText(getContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }
//        return true;
//    }
}