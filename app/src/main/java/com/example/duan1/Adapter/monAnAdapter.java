package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.DAO.monAnDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.manHinhChinh;
import com.example.duan1.model.gioHang;
import com.example.duan1.model.monAn;

import java.util.ArrayList;

public class monAnAdapter extends RecyclerView.Adapter<monAnAdapter.monAnViewHolder> {

    ArrayList<monAn> list;
    DbHelper dbHelper;
    Context context;
    monAnDAO maDAO;

    gioHangDAO ghDAO;



    public monAnAdapter(ArrayList<monAn> list, DbHelper dbHelper, Context context) {
        this.list = list;
        this.dbHelper = dbHelper;
        this.context = context;
    }

    @NonNull
    @Override
    public monAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_mon_an_chi_tiet, parent, false);
        return new monAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull monAnViewHolder holder, int position) {
        holder.tv_ten.setText(list.get(position).getTenMonAn());
        holder.tv_moTa.setText(list.get(position).getMoTaMonAn());
        holder.tv_gia.setText(String.valueOf(list.get(position).getGiaMonAn()));



        holder.btn_gh_themMonAn.setOnClickListener(v -> {
//            gioHang gh = new gioHang();
//            gh.getGia();
//            gh.getTenMon();
//            gh.getSoLuong();
//            ghDAO = new gioHangDAO(context);
//            boolean check = ghDAO.addMon(gh);
//            if(check){
//                Toast.makeText(context, "them thanh cong", Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(context, "them that bai", Toast.LENGTH_SHORT).show();
//            }

       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class monAnViewHolder extends RecyclerView.ViewHolder {

        TextView tv_gia, tv_moTa, tv_ten;
        Button btn_gh_themMonAn;

        public monAnViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_gia = itemView.findViewById(R.id.tv_giaMonAn);
            tv_moTa = itemView.findViewById(R.id.tv_moTaMonAn);
            tv_ten = itemView.findViewById(R.id.tv_tenMonAn);
            btn_gh_themMonAn = itemView.findViewById(R.id.btn_gh_addMonAn);

        }
    }
}
