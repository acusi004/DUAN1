package com.example.duan1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.Adapter.hoaDonAdapter;
import com.example.duan1.DAO.hoaDonDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.donHang;

import java.util.ArrayList;

public class hoaDon_Fragment extends Fragment {

    RecyclerView rcv_donHangg;

    hoaDonDAO dhDAO;

    DbHelper dbHelper;

    ArrayList<donHang> list;

    hoaDonAdapter dhAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoa_don_, container, false);
        rcv_donHangg = view.findViewById(R.id.rcv_donHang);

        getAllrecycleDonHang();
        return view;
    }

    public void getAllrecycleDonHang(){
        dhDAO = new hoaDonDAO(getContext());
        list = dhDAO.getAll();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_donHangg.setLayoutManager(linearLayoutManager);

        dhAdapter = new hoaDonAdapter(list, dbHelper, getContext(), dhDAO);

        rcv_donHangg.setAdapter(dhAdapter);
        dhAdapter.notifyDataSetChanged();

    }
}