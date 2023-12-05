package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.duan1.DAO.thongKeDAO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class doanhThu extends AppCompatActivity {

    View view;
    EditText edt_tuNgay, edt_denNgay;
    TextView txt_DoanhThu;

    Button btn_tuNgay , btn_denNgay, btn_find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doanh_thu);

        edt_tuNgay = findViewById(R.id.edt_TuNgay);
        edt_denNgay = findViewById(R.id.edt_DenNgay);
        txt_DoanhThu = findViewById(R.id.txt_DoanhThu);
        btn_tuNgay = findViewById(R.id.btn_TuNgay);
        btn_denNgay = findViewById(R.id.btn_DenNgay);
        btn_find = findViewById(R.id.btn_find);

        btn_tuNgay.setOnClickListener(v -> {
            showDatePickerDialog(edt_tuNgay);
        });
        btn_denNgay.setOnClickListener(v -> {
            showDatePickerDialog(edt_denNgay);
        });

        btn_find.setOnClickListener(v -> {
            thongKeDAO tkDAO = new thongKeDAO(this);
            String star = edt_tuNgay.getText().toString();
            String end = edt_denNgay.getText().toString();
            int doanhThu = tkDAO.doanhThu(star, end);
            txt_DoanhThu.setText(doanhThu + " VND");
        });



    }


    private void showDatePickerDialog(EditText editText) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, yearSelected, monthOfYear, dayOfMonthSelected) -> {
                    Calendar selectedDateCalendar = Calendar.getInstance();
                    selectedDateCalendar.set(yearSelected, monthOfYear, dayOfMonthSelected);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    String selectedDate = sdf.format(selectedDateCalendar.getTime());
                    editText.setText(selectedDate);
                },
                year,
                month,
                dayOfMonth
        );
        datePickerDialog.show();
    }
}