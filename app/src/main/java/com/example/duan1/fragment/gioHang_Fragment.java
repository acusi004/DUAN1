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
import android.widget.TextView;

import com.example.duan1.Adapter.gioHangAdapter;
import com.example.duan1.Adapter.gioHangAdapter.onSoLuongDownClickListener;
import com.example.duan1.Adapter.gioHangAdapter.onSoLuongUpClickListener;
import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.gioHang;

import java.util.ArrayList;


public class gioHang_Fragment extends Fragment implements onSoLuongUpClickListener, onSoLuongDownClickListener{

    RecyclerView rcv_gioHang;
    Button btn_datHang;
    gioHangDAO ghDAO;

    ArrayList<gioHang> list = new ArrayList<>();

    gioHangAdapter ghAdapter;
    DbHelper dbHelper;
    TextView tv_sumMonAn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gio_hang_, container, false);
        rcv_gioHang = view.findViewById(R.id.rcv_gioHang);
        tv_sumMonAn = view.findViewById(R.id.tv_giaTongSoLuongMonAn);
        btn_datHang = view.findViewById(R.id.btn_datHang);

        btn_datHang.setOnClickListener(v -> {
              datHangDiaLog();
        });
        recyclerViewGioHang();
        updateGia();
        return view;
    }

    public void datHangDiaLog(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_item_confirm_gio_hang);

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
       ghAdapter.setOnSoLuongDownClickListener(this);
       ghAdapter.setOnSoLuongUpClickListener(this);
       rcv_gioHang.setAdapter(ghAdapter);
       ghAdapter.notifyDataSetChanged();


    }





    private int sumDonHang(){
        int gia = 0;
        for(gioHang gh: list){
            gia += gh.getGia();
        }

        return gia;
    }

    private void updateGia(){
        int gia = sumDonHang();
        tv_sumMonAn.setText(String.valueOf(gia)+" VND");

    }

    @Override
    public void plusSoLuongClick(int position) {
        updateGia();
    }

    @Override
    public void minusSoLuongClick(int position) {
        updateGia();
    }
}