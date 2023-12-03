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

import com.example.duan1.DAO.hoaDonDAO;
import com.example.duan1.DAO.gioHangDAO;
import com.example.duan1.R;
import com.example.duan1.database.DbHelper;
import com.example.duan1.model.donHang;
import com.example.duan1.model.gioHang;

import java.util.ArrayList;

public class hoaDonAdapter extends RecyclerView.Adapter<hoaDonAdapter.hoaDonViewHolder> {

    ArrayList<donHang> list = new ArrayList<>();


    DbHelper dbHelper;
    Context context;

    hoaDonDAO dhDAO;

    public hoaDonAdapter(ArrayList<donHang> list, DbHelper dbHelper, Context context, hoaDonDAO dhDAO) {
        this.list = list;
        this.dbHelper = dbHelper;
        this.context = context;
        this.dhDAO = dhDAO;
    }

    @NonNull
    @Override
    public hoaDonAdapter.hoaDonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_rcv_hoa_don, parent, false);
        return new hoaDonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hoaDonAdapter.hoaDonViewHolder holder, int position) {
        holder.tv_sum.setText(String.valueOf(list.get(position).getTongTien()+ " VND"));
        holder.tv_content.setText(list.get(position).getContent());
        holder.tv_diaChi.setText(list.get(position).getDiaChi());
        holder.tv_sdt.setText( "0"+String.valueOf(+list.get(position).getSdt()));

        String tt = "";
        if(list.get(position).getTrangThai() ==0){
            tt = "ĐANG GIAO HÀNG";
            holder.btn_confirm_donHang.setVisibility(View.VISIBLE);
        }else{
            tt = "GIAO THÀNH CÔNG";
            holder.btn_confirm_donHang.setVisibility(View.GONE);
        }
        holder.tv_trangThai.setText(tt);

        holder.btn_confirm_donHang.setOnClickListener(v -> {
            dhDAO = new hoaDonDAO(context);


            boolean check = dhDAO.updateTT(list.get(holder.getAdapterPosition()).getTrangThai());

            if(check){
                list.clear();
                list = dhDAO.getAll();
                notifyDataSetChanged();
                Toast.makeText(context, "da nhan hang", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "chua nhan hang", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class hoaDonViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_img;

        Button btn_confirm_donHang;

        TextView tv_trangThai, tv_content, tv_sdt, tv_diaChi, tv_sum;

        public hoaDonViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img_donHang);
            btn_confirm_donHang = itemView.findViewById(R.id.btn_daNhanHang);
            tv_diaChi = itemView.findViewById(R.id.tv_hd_diaChi);
            tv_sdt = itemView.findViewById(R.id.tv_hd_soDienThoai);
            tv_content = itemView.findViewById(R.id.tv_hd_content);
            tv_trangThai = itemView.findViewById(R.id.tv_hd_trangThai);
            tv_sum = itemView.findViewById(R.id.id_sum);

        }
    }





}
