package com.example.duan1.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1.Adapter.monAnAdapter;
import com.example.duan1.DAO.monAnDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.loaiMon;
import com.example.duan1.model.monAn;
import com.example.duan1.tablayout.viewPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.example.duan1.DAO.loaiDao;

import java.util.ArrayList;


public class trangChu_Fragment extends Fragment {


    TabLayout tabLayout;
    ViewPager2 vPager2;
    FloatingActionButton floatingActionButton;
    viewPagerAdapter viewPagerAdapter;
    monAnDAO maDAO;
    monAnAdapter monAnAdapter;
    ArrayList<loaiMon>listLoaiMon = new ArrayList<>();
    loaiDao loaiDao;
    monAn ma = new monAn();
    DbHelper dbHelper;
    ArrayList<monAn> listMa = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        loaiDao = new loaiDao(getContext());
        dbHelper = new DbHelper(getContext());
        monAnAdapter = new monAnAdapter(listMa, dbHelper, getContext());
        View view = inflater.inflate(R.layout.fragment_trang_chu_, container, false);
        tabLayout = view.findViewById(R.id.tab_danhMuc);
        vPager2 = view.findViewById(R.id.viewPager2);
        floatingActionButton = view.findViewById(R.id.btn_add_monan);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAddMonAn();
            }
        });
        viewPagerAdapter = new viewPagerAdapter(getActivity());
        viewPagerAdapter.addFragment(new burgerFragment());
        viewPagerAdapter.addFragment(new pizzaFragment());
        viewPagerAdapter.addFragment(new nuocUongFragment());
        vPager2.setAdapter(viewPagerAdapter);
        setEvenTablayout();
        viewPagerCallback();


        return view;
    }

    public void setEvenTablayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void viewPagerCallback(){
        vPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }
//    private void loadFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getParentFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.relative, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }
    public void dialogAddMonAn(){

        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.item_dialog);
        TextInputEditText edt_tenMonAn ,edt_gia, edt_moTa, edtLinkAnh;
        Button btn_add_confirm;
        Spinner spinnerTenLoai;


        edt_tenMonAn = dialog.findViewById(R.id.edt_tenMon);
        edt_moTa = dialog.findViewById(R.id.edt_moTa);
        edt_gia = dialog.findViewById(R.id.edt_gia);
        edtLinkAnh = dialog.findViewById(R.id.edt_LinkAnh);
        btn_add_confirm = dialog.findViewById(R.id.btn_add_admin_confirm);
        spinnerTenLoai = dialog.findViewById(R.id.spnTenLoaiMon);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,loaiDao.name() );
        spinnerTenLoai.setAdapter(adapter1);

        spinnerTenLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listLoaiMon = loaiDao.getDSLoaiMon();
                ma.setTenLoai(listLoaiMon.get(position).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_add_confirm.setOnClickListener(v -> {
            maDAO = new monAnDAO(getContext());
            String ten = edt_tenMonAn.getText().toString();
            String gia = edt_gia.getText().toString();
            String moTa  = edt_moTa.getText().toString().trim();
            String linkAnh = edtLinkAnh.getText().toString();

            if(ten.equals("")||gia.equals("")||moTa.equals("")||linkAnh.equals("")){
                Toast.makeText(getContext(), "Cần nhập dữ liêu", Toast.LENGTH_SHORT).show();
            } else {

                ma.setTenMonAn(ten);
                ma.setGiaMonAn(Integer.parseInt(gia));
                ma.setMoTaMonAn(moTa);
                ma.setImg(linkAnh);
                boolean check = maDAO.add(ma);
                if(check){
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    listMa.add(ma);
                    monAnAdapter.notifyDataSetChanged();
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

}