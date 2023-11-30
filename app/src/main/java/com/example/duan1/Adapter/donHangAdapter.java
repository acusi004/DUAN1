package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.manHinhChinh;
import com.example.duan1.model.donHang;

import java.util.ArrayList;

public class donHangAdapter extends RecyclerView.Adapter<donHangAdapter.hoaDonViewHolder> {

    ArrayList<donHang> list = new ArrayList<>();

    DbHelper dbHelper;
    Context context;

    public donHangAdapter(ArrayList<donHang> list, DbHelper dbHelper, Context context) {
        this.list = list;
        this.dbHelper = dbHelper;
        this.context = context;
    }

    @NonNull
    @Override
    public donHangAdapter.hoaDonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_hoa_don, parent, false);
        return new hoaDonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull donHangAdapter.hoaDonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class hoaDonViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_img;

        Button btn_confirm_donHang;

        TextView tv_trangThai, tv_tenMon, tv_soLuong, tv_giaMon, tv_sdt, tv_diaChi;

        public hoaDonViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img_donHang);
            btn_confirm_donHang = itemView.findViewById(R.id.btn_daNhanHang);
            tv_diaChi = itemView.findViewById(R.id.tv_hd_diaChi);
            tv_sdt = itemView.findViewById(R.id.tv_hd_soDienThoai);
            tv_tenMon = itemView.findViewById(R.id.tv_hd_content);
            tv_trangThai = itemView.findViewById(R.id.tv_hd_trangThai);

        }
    }
}
