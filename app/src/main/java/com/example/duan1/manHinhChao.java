package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class manHinhChao extends AppCompatActivity {

    Button btn_getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchao);
        btn_getStarted = findViewById(R.id.btn_getStarted);
        btn_getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(manHinhChao.this, dangNhap.class));
                finish();
            }
        });
    }
}