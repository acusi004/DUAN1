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

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Adapter.monAnAdapter;
import com.example.duan1.DAO.burGerDAO;
import com.example.duan1.DAO.loaiDao;
import com.example.duan1.DAO.monAnDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.monAn;
import com.example.duan1.model.loaiMon;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


public class burgerFragment extends Fragment {

    RecyclerView rcv_phoBien;


    monAnAdapter adapterMa;

    burGerDAO bgDAO;
    loaiDao loaiDao;

    DbHelper dbHelper;


    TextView tv_all;
    monAn ma = new monAn();
    ArrayList<monAn> listMa = new ArrayList<>();
    monAnDAO maDAO;
    monAnAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_burger, container, false);
        rcv_phoBien = view.findViewById(R.id.rcv_phoBien);
        tv_all = view.findViewById(R.id.tv_viewAll);
        loaiDao = new loaiDao(getContext());
        dbHelper = new DbHelper(getContext());
        bgDAO = new burGerDAO(getContext());
        adapter = new monAnAdapter(listMa, dbHelper, getContext());
        ArrayList<loaiMon> listCat = loaiDao.getDSLoaiMon();
        rcvGetBurger();
        tv_all.setOnClickListener(v -> {
            recycleviewphoBien();
        });



        return view;
    }

    public void rcvGetBurger(){
        listMa = bgDAO.getBuger();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_phoBien.setLayoutManager(linearLayoutManager);

        adapterMa = new monAnAdapter(listMa, dbHelper, getContext());
        rcv_phoBien.setAdapter(adapterMa);

    }

    public void recycleviewphoBien(){
        maDAO = new monAnDAO(getContext());
        listMa = maDAO.getALl();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_phoBien.setLayoutManager(linearLayoutManager);

        adapterMa = new monAnAdapter(listMa,dbHelper,getContext());
        rcv_phoBien.setAdapter(adapterMa);
    }


}