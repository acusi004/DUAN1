package com.example.duan1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.Adapter.danhMucAdapter;
import com.example.duan1.Adapter.monAnAdapter;
import com.example.duan1.DAO.monAnDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.danhMuc;
import com.example.duan1.model.monAn;

import java.util.ArrayList;


public class trangChu_Fragment extends Fragment {

    RecyclerView rcv_danhMuc, rcv_phoBien;

    ArrayList<danhMuc> listDm = new ArrayList<>();
    ArrayList<monAn> listMa = new ArrayList<>();

    danhMucAdapter adapterDm;
    monAnAdapter adapterMa;

    monAnDAO maDAO;

    DbHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trang_chu_, container, false);
        rcv_danhMuc = view.findViewById(R.id.rcv_danhMuc);
        rcv_phoBien = view.findViewById(R.id.rcv_phoBien);
        recycleviewDanhMuc();
        recycleviewphoBien();
        return view;
    }

    private void recycleviewDanhMuc(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcv_danhMuc.setLayoutManager(linearLayoutManager);

        listDm.add(new danhMuc(R.drawable.cat_1));
        listDm.add(new danhMuc(R.drawable.cat_2));
        listDm.add(new danhMuc(R.drawable.cat_3));
        listDm.add(new danhMuc(R.drawable.cat_4));
        listDm.add(new danhMuc(R.drawable.cat_5));

        adapterDm = new danhMucAdapter(getContext(), listDm);
        rcv_danhMuc.setAdapter(adapterDm);
    }

    private  void recycleviewphoBien(){
        maDAO = new monAnDAO(getContext());
        listMa = maDAO.getALl();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_phoBien.setLayoutManager(linearLayoutManager);

        adapterMa = new monAnAdapter(listMa,dbHelper,getContext());
        rcv_phoBien.setAdapter(adapterMa);

    }


}