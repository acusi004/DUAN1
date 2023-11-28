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
import com.example.duan1.DAO.pizzaDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.monAn;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class pizzaFragment extends Fragment {

    monAnDAO maDAO;
    ArrayList<monAn> listMa = new ArrayList<>();
    RecyclerView rcv_pizza;
    FloatingActionButton btn_addPizza;
    monAnAdapter adapterMa;
    DbHelper dbHelper;

    TextView tv_seeAll;

    pizzaDAO pzDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
        rcv_pizza = view.findViewById(R.id.rcv_pizza);
        btn_addPizza = view.findViewById(R.id.btn_add_admin_pizza);
        tv_seeAll = view.findViewById(R.id.tv_viewAll_pizza);
        getAllPizza();
        tv_seeAll.setOnClickListener(v -> {
            recycleviewALL();
        });
        return view;
    }

    private void getAllPizza() {
        pzDAO = new pizzaDAO(getContext());
        listMa = pzDAO.getPizza();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_pizza.setLayoutManager(linearLayoutManager);

        adapterMa = new monAnAdapter(listMa,dbHelper,getContext());
        rcv_pizza.setAdapter(adapterMa);
    }

    private  void recycleviewALL(){
        maDAO = new monAnDAO(getContext());
        listMa = maDAO.getALl();

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_pizza.setLayoutManager(linearLayoutManager);

        adapterMa = new monAnAdapter(listMa,dbHelper,getContext());
        rcv_pizza.setAdapter(adapterMa);

    }
}