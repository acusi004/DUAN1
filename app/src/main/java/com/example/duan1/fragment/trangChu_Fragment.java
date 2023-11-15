package com.example.duan1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.Adapter.danhMucAdapter;
import com.example.duan1.R;
import com.example.duan1.model.danhMuc;

import java.util.ArrayList;


public class trangChu_Fragment extends Fragment {

    RecyclerView rcv_danhMuc;

    ArrayList<danhMuc> list = new ArrayList<>();

    danhMucAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trang_chu_, container, false);
        rcv_danhMuc = view.findViewById(R.id.rcv_danhMuc);
        recycleviewDanhMuc();
        return view;
    }

    private void recycleviewDanhMuc(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcv_danhMuc.setLayoutManager(linearLayoutManager);

        list.add(new danhMuc(R.drawable.cat_1));
        list.add(new danhMuc(R.drawable.cat_2));
        list.add(new danhMuc(R.drawable.cat_3));
        list.add(new danhMuc(R.drawable.cat_4));
        list.add(new danhMuc(R.drawable.cat_5));

        adapter = new danhMucAdapter(getContext(), list);
        rcv_danhMuc.setAdapter(adapter);

    }


}