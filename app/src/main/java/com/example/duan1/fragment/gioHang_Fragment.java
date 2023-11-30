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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1.Adapter.gioHangAdapter;

import com.example.duan1.DAO.donHangDAO;
import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.DAO.monAnDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.donHang;
import com.example.duan1.model.gioHang;
import com.example.duan1.model.monAn;

import java.util.ArrayList;


public class gioHang_Fragment extends Fragment{

    RecyclerView rcv_gioHang;
    Button btn_datHang;
    gioHangDAO ghDAO;

    monAnDAO maDAO;

    ArrayList<gioHang> list = new ArrayList<>();
    ArrayList<monAn> listMa = new ArrayList<>();

    gioHangAdapter ghAdapter;
    DbHelper dbHelper;


    donHang dh;

    gioHang gh;

    donHangDAO dhDAO;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gio_hang_, container, false);
        rcv_gioHang = view.findViewById(R.id.rcv_gioHang);

        btn_datHang = view.findViewById(R.id.btn_datHang);

        btn_datHang.setOnClickListener(v -> {
              datHangDiaLog();
        });
        recyclerViewGioHang();

        return view;
    }

    public void datHangDiaLog(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_item_confirm_gio_hang);

        EditText edt_sdt, edt_diaChi;
        Button btn_confirm;
        TextView tv_content, tv_price;

        ghDAO = new gioHangDAO(getContext());
        maDAO = new monAnDAO(getContext());

        edt_sdt = dialog.findViewById(R.id.edt_dh_sdt);
        edt_diaChi = dialog.findViewById(R.id.edt_dh_diaChi);
        tv_content = dialog.findViewById(R.id.tv_dialog_hd_confirm_content);
        tv_price = dialog.findViewById(R.id.tv_dialog_hd_confirm_priceSum);
        btn_confirm = dialog.findViewById(R.id.btn__dh_xacNhanDatHang);


        // lay du lieu len dialog confirm
        String dataGioHang = "";
        listMa = maDAO.getALl();
        list = ghDAO.getAll();
        for(gioHang gh : list){
            for(monAn ma: listMa){
                if(ma.getMaMonAn() == gh.getMaMonAn()){
                    dataGioHang += "-" + ma.getTenMonAn() + "(" + gh.getGia() + " VND)" + ", So luong: " + gh.getSoLuong() + "\n";
                    break;
                }
            }
        }
        String content = dataGioHang;

        tv_content.setText(content);

        int sum = calculateTotalSum();
        tv_price.setText(String.valueOf(sum));


        btn_confirm.setOnClickListener(v -> {
            String sdt = edt_sdt.getText().toString();
            String diaChi = edt_diaChi.getText().toString();

            if(sdt.equals("")||diaChi.equals("")){
                Toast.makeText(getContext(), "Cần nhạp dữ liệu", Toast.LENGTH_SHORT).show();
            }else{
                dhDAO = new donHangDAO(getContext());
                gh = new gioHang();
                dh = new donHang();
                dh.setDiaChi(diaChi);
                dh.setSdt(Integer.parseInt(sdt));
                dh.setGiaMon(gh.getGia());
                dh.setImg(gh.getImg());
                dh.setTenMon(gh.getTenMonAn());
                dh.setSoLuong(gh.getSoLuong());

                if(!(dhDAO.insertDonHang(dh))){
                    Toast.makeText(getContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }



            }
        });

//        code o day

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public void recyclerViewGioHang(){

       ghDAO = new gioHangDAO(getContext());
       list = ghDAO.getAll();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv_gioHang.setLayoutManager(linearLayoutManager);

       ghAdapter = new gioHangAdapter(list,dbHelper, getContext(), ghDAO);

       rcv_gioHang.setAdapter(ghAdapter);
       ghAdapter.notifyDataSetChanged();


    }



    private int calculateTotalSum() {
        int totalSum = 0;
        for (gioHang gh : list) {
            totalSum += gh.getGia();
        }
        return totalSum;
    }











}