package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.DAO.lichSuDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.manHinhChinh;
import com.example.duan1.model.lichSu;

import java.util.ArrayList;

public class lichSuAdapter extends RecyclerView.Adapter<lichSuAdapter.lichSuViewHolder> {

    Context context;

    ArrayList<lichSu> listLs = new ArrayList<>();

    DbHelper dbHelper;

    lichSuDAO lsDAO;

    public lichSuAdapter(Context context, ArrayList<lichSu> listLs, DbHelper dbHelper, lichSuDAO lsDAO) {
        this.context = context;
        this.listLs = listLs;
        this.dbHelper = dbHelper;
        this.lsDAO = lsDAO;
    }

    @NonNull
    @Override
    public lichSuAdapter.lichSuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcv_lich_su, parent, false);
        return new lichSuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lichSuAdapter.lichSuViewHolder holder, int position) {
        holder.tv_ls_date.setText(listLs.get(position).getDate());
        holder.tv_ls_sdt.setText("0"+String.valueOf(listLs.get(position).getSdt()));
        String tt = "";
        if(listLs.get(position).getTrangThai() ==1){
            tt = "GIAO THÀNH CÔNG";
        }else{
            tt = "GIAO THẤT BẠI";
        }

        holder.tv_ls_tt.setText(tt);
        holder.tv_ls_sum.setText(String.valueOf(listLs.get(position).getTongTien()+ " VND"));
        holder.tv_ls_diaChi.setText(listLs.get(position).getDiaChi());
        holder.tv_ls_content.setText(listLs.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return listLs.size();
    }

    public class lichSuViewHolder extends RecyclerView.ViewHolder {

        TextView tv_ls_tt, tv_ls_date, tv_ls_content, tv_ls_sum, tv_ls_sdt, tv_ls_diaChi;
        public lichSuViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ls_content = itemView.findViewById(R.id.tv_ls_content);
            tv_ls_diaChi = itemView.findViewById(R.id.tv_ls_diaChi);
            tv_ls_date = itemView.findViewById(R.id.tv_ls_ngayDat);
            tv_ls_sdt = itemView.findViewById(R.id.tv_ls_soDienThoai);
            tv_ls_tt = itemView.findViewById(R.id.tv_ls_trangThai);
            tv_ls_sum = itemView.findViewById(R.id.tv_ls_sum);
        }
    }
}
