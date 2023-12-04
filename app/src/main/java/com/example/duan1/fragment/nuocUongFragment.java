package com.example.duan1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.duan1.Adapter.monAnAdapter;
import com.example.duan1.DAO.monAnDAO;
import com.example.duan1.DAO.nuocUongDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.monAn;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class nuocUongFragment extends Fragment {

    monAnDAO maDAO;
    ArrayList<monAn> listMa = new ArrayList<>();
    RecyclerView rcv_nuocUong;
    FloatingActionButton btn_addNuocUong;
    monAnAdapter adapterMa;
    DbHelper dbHelper;

    TextView tv_seeAll;

    nuocUongDAO ncDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nuoc_uong, container, false);
        tv_seeAll = view.findViewById(R.id.tv_viewAll_nuocUuong);
        rcv_nuocUong = view.findViewById(R.id.rcv_nuocUong);
        getAllNuocUong();
        tv_seeAll.setOnClickListener(v -> {
          recycleviewALL();
        });
        return view;
    }

    private void getAllNuocUong(){
        ncDAO = new nuocUongDAO(getContext());
        listMa = ncDAO.getNuoUong();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_nuocUong.setLayoutManager(linearLayoutManager);

        adapterMa = new monAnAdapter(listMa, dbHelper, getContext());
        rcv_nuocUong.setAdapter(adapterMa);

    }

    private  void recycleviewALL(){
        maDAO = new monAnDAO(getContext());
        listMa = maDAO.getALl();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_nuocUong.setLayoutManager(linearLayoutManager);

        adapterMa = new monAnAdapter(listMa,dbHelper,getContext());
        rcv_nuocUong.setAdapter(adapterMa);

    }

}