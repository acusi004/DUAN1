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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    monAnAdapter adapterMa;
    DbHelper dbHelper;

    TextView tv_seeAll;

    pizzaDAO pzDAO;
    Spinner spinnerTenLoai;
    monAn ma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
        rcv_pizza = view.findViewById(R.id.rcv_pizza);
        tv_seeAll = view.findViewById(R.id.tv_viewAll_pizza);
        getAllPizza();
        tv_seeAll.setOnClickListener(v -> {
            recycleviewALL();
        });
//        btn_addPizza.setOnClickListener(v -> {
//            dialogAddMonAn();
//        });
        return view;
    }
    public void dialogAddMonAn(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.item_dialog);


        EditText edt_tenMonAn ,edt_gia, edt_moTa;
        Button btn_add_confirm;

        edt_tenMonAn = dialog.findViewById(R.id.edt_tenMon);
        edt_moTa = dialog.findViewById(R.id.edt_moTa);
        edt_gia = dialog.findViewById(R.id.edt_gia);
        btn_add_confirm = dialog.findViewById(R.id.btn_add_admin_confirm);
        spinnerTenLoai = dialog.findViewById(R.id.spnTenLoaiMon);
        ArrayList<String> listTenLoai = maDAO.getTenLoaiMonAnList();
        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,listTenLoai );
        spinerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTenLoai.setAdapter(spinerAdapter);

        btn_add_confirm.setOnClickListener(v -> {
            String ten = edt_tenMonAn.getText().toString();
            String gia = edt_gia.getText().toString();
            String moTa  = edt_moTa.getText().toString().trim();

            if(ten.equals("")||gia.equals("")||moTa.equals("")){
                Toast.makeText(getContext(), "Cần nhập dữ liêu", Toast.LENGTH_SHORT).show();
            } else {
                ma = new monAn();
                ma.setTenMonAn(ten);
                ma.setGiaMonAn(Integer.parseInt(gia));
                ma.setMoTaMonAn(moTa);
                ma.setTenLoai(spinnerTenLoai.getSelectedItem().toString());
                maDAO = new monAnDAO(getContext());
                boolean check = maDAO.add(ma);
                if(check){
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    listMa.add(ma);
                    adapterMa.notifyDataSetChanged();
                    dialog.dismiss();
                }else{
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }

        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
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