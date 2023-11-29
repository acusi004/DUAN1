package com.example.duan1.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Adapter.gioHangAdapter;

import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.donHang;
import com.example.duan1.model.gioHang;

import java.util.ArrayList;


public class gioHang_Fragment extends Fragment{

    RecyclerView rcv_gioHang;
    Button btn_datHang;
    gioHangDAO ghDAO;

    ArrayList<gioHang> list = new ArrayList<>();

    gioHangAdapter ghAdapter;
    DbHelper dbHelper;
    TextView tv_sumMonAn;

    donHang dh;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gio_hang_, container, false);
        rcv_gioHang = view.findViewById(R.id.rcv_gioHang);

        btn_datHang = view.findViewById(R.id.btn_datHang);

        btn_datHang.setOnClickListener(v -> {
              datHangDiaLog();
        });
        recyclerViewGioHang();

        return view;
    }

    public void datHangDiaLog(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_item_confirm_gio_hang);

        EditText edt_sdt, edt_diaChi;
        Button btn_confirm;

        edt_sdt = dialog.findViewById(R.id.edt_dh_sdt);
        edt_diaChi = dialog.findViewById(R.id.edt_dh_diaChi);
        btn_confirm = dialog.findViewById(R.id.btn__dh_xacNhanDatHang);

        btn_confirm.setOnClickListener(v -> {
            String sdt = edt_sdt.getText().toString();
            String diaChi = edt_diaChi.getText().toString();

            if(sdt.equals("")||diaChi.equals("")){
                Toast.makeText(getContext(), "Cần nhạp dữ liệu", Toast.LENGTH_SHORT).show();
            }else{
                dh = new donHang();
                dh.setDiaChi(diaChi);
                dh.setSdt(Integer.parseInt(sdt));

            }
        });

//        code o day

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public void recyclerViewGioHang(){

       ghDAO = new gioHangDAO(getContext());
       list = ghDAO.getAll();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_gioHang.setLayoutManager(linearLayoutManager);

       ghAdapter = new gioHangAdapter(list,dbHelper, getContext(), ghDAO);

       rcv_gioHang.setAdapter(ghAdapter);
       ghAdapter.notifyDataSetChanged();


    }











}