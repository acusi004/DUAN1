package com.example.duan1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.duan1.Adapter.gioHangAdapter;
import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.gioHang;

import java.util.ArrayList;


public class gioHang_Fragment extends Fragment {

    RecyclerView rcv_gioHang;
    Button btn_datHang;
    gioHangDAO ghDAO;

    ArrayList<gioHang> list = new ArrayList<>();

    gioHangAdapter ghAdapter;
    DbHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gio_hang_, container, false);
        rcv_gioHang = view.findViewById(R.id.rcv_gioHang);
        recyclerViewGioHang();
        return view;
    }

    public void recyclerViewGioHang(){

       ghDAO = new gioHangDAO(getContext());
       list = ghDAO.getAll();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_gioHang.setLayoutManager(linearLayoutManager);

       ghAdapter = new gioHangAdapter(list,dbHelper, getContext());
       rcv_gioHang.setAdapter(ghAdapter);
       ghAdapter.notifyDataSetChanged();


    }
}