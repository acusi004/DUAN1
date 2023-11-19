package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.gioHang;

import java.util.ArrayList;

public class gioHangAdapter extends RecyclerView.Adapter<gioHangAdapter.gioHangViewHolder> {

    ArrayList<gioHang> list = new ArrayList<>();
    DbHelper dbHelper;
    Context context;
    gioHangDAO ghDAO;

    public gioHangAdapter(ArrayList<gioHang> list, DbHelper dbHelper, Context context) {
        this.list = list;
        this.dbHelper = dbHelper;
        this.context = context;
    }

    @NonNull
    @Override
    public gioHangAdapter.gioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcv_gio_hang, parent, false);
        return new gioHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gioHangAdapter.gioHangViewHolder holder, int position) {
        holder.tv_gia.setText(String.valueOf(list.get(position).getGia()));
        holder.tv_soLuong.setText(String.valueOf(list.get(position).getSoLuong()));
        holder.tv_tenMon.setText(list.get(position).getTenMon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class gioHangViewHolder extends RecyclerView.ViewHolder {

        TextView tv_tenMon, tv_soLuong, tv_gia;

        public gioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_gia = itemView.findViewById(R.id.tv_gh_gia);
            tv_soLuong = itemView.findViewById(R.id.tv_gh_soLuong);
            tv_tenMon = itemView.findViewById(R.id.tv_gh_tenMon);
        }
    }
}
