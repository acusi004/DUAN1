package com.example.duan1.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.Adapter.gioHangAdapter;
import com.example.duan1.Adapter.lichSuAdapter;
import com.example.duan1.DAO.lichSuDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.lichSu;

import java.util.ArrayList;


public class lichSu_Fragment extends Fragment {


    RecyclerView rcv_lichSu;

    lichSuAdapter lsAdapter;

    lichSuDAO lsDAO;

    Context context;
    ArrayList<lichSu> list = new ArrayList<>();

    DbHelper dbHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_lich_su_, container, false);
        rcv_lichSu = view.findViewById(R.id.rcv_lichSu);
        getAllrecycleLichSu();
        return view;
    }

    public void getAllrecycleLichSu(){
        lsDAO = new lichSuDAO(getContext());
        list = lsDAO.getALl();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_lichSu.setLayoutManager(linearLayoutManager);

        lsAdapter = new lichSuAdapter(getContext(), list, dbHelper, lsDAO);
        rcv_lichSu.setAdapter(lsAdapter);
        lsAdapter.notifyDataSetChanged();
    }

}