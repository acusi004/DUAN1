package com.example.duan1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.Adapter.donHangAdapter;
import com.example.duan1.Adapter.gioHangAdapter;
import com.example.duan1.DAO.donHangDAO;
import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.donHang;
import com.example.duan1.model.gioHang;

import java.util.ArrayList;


public class donHangFragment extends Fragment {


    RecyclerView rcv_donHang;

    donHangDAO dhDAO;

    DbHelper dbHelper;

    ArrayList<donHang> list;

    donHangAdapter dhAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_don_hang, container, false);
        rcv_donHang = view.findViewById(R.id.rcv_donHang);

        return view;
    }

    public void getAllrecycleDonHang(){
       dhDAO = new donHangDAO(getContext());
       list = dhDAO.getAll();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_donHang.setLayoutManager(linearLayoutManager);

        dhAdapter = new donHangAdapter(list, dbHelper, getContext());

        rcv_donHang.setAdapter(dhAdapter);
        dhAdapter.notifyDataSetChanged();

    }
}