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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1.Adapter.monAnAdapter;
import com.example.duan1.DAO.burGerDAO;
import com.example.duan1.DAO.monAnDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.monAn;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class burgerFragment extends Fragment {

    RecyclerView rcv_phoBien;


    ArrayList<monAn> listMa = new ArrayList<>();


    monAnAdapter adapterMa;


    monAnDAO maDAO;



    DbHelper dbHelper;

    FloatingActionButton btn_addMonAn;

    burGerDAO bgDAO;

    monAn ma;


    Spinner spn_tenLoai;

    int maLoai, positionMa;
    String tenLoai;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_burger, container, false);
        rcv_phoBien = view.findViewById(R.id.rcv_phoBien);
        btn_addMonAn = view.findViewById(R.id.btn_add_admin);

        btn_addMonAn.setOnClickListener(v -> {
            dialogAddMonAn();
        });

        recycleviewphoBien();
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