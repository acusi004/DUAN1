package com.example.duan1.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
        holder.tv_gia.setText(String.valueOf(list.get(position).getGiaMonAn()+ " VND"));


        // chuc nang sua mon an admin
        holder.itemView.setOnClickListener(v -> {
            Dialog dialog = new Dialog(v.getContext());
            dialog.setContentView(R.layout.item_dialog);

            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.show();
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_item_delete_gio_hang);


                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                Button btn_co, btn_khong;
                btn_khong = dialog.findViewById(R.id.item_dialog_delete_khong);
                btn_co = dialog.findViewById(R.id.item_dialog_delete_co);

                btn_co.setOnClickListener(v13 -> {
                    maDAO = new monAnDAO(v.getContext());
                    int maMonAn = list.get(holder.getAdapterPosition()).getMaMonAn();
                    boolean check = maDAO.delete(maMonAn);
                    if(check){
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        list.clear();
                        list = maDAO.getALl();
                        notifyItemRemoved(holder.getAdapterPosition());
                        dialog.dismiss();
                    }else{
                        Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
                btn_khong.setOnClickListener(v14 -> {
                    dialog.dismiss();
                });


                dialog.show();
                return true;
            }
        });

        holder.btn_gh_themMonAn.setOnClickListener(v -> {
            Dialog dialog = new Dialog(v.getContext());
            dialog.setContentView(R.layout.dialog_item_add_cart);


            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            Button btn_them, btn_huy;
            btn_them = dialog.findViewById(R.id.item_dialog_them);
            btn_huy = dialog.findViewById(R.id.item_dialog_huy);
            monAn ma = list.get(position);

            btn_them.setOnClickListener(v12 -> {
                gioHangDAO ghDAO = new gioHangDAO(context);
                gioHang gh = new gioHang();
                gh.setMaMonAn(ma.getMaMonAn());
                gh.setSoLuong(1);
                gh.setGia(ma.getGiaMonAn());
                if(!(ghDAO.addMon(gh))){
                    Toast.makeText(context, "them that bai", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "them thanh cong", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

            });

            btn_huy.setOnClickListener(v1 -> {
                dialog.dismiss();
            });



            dialog.show();
       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class monAnViewHolder extends RecyclerView.ViewHolder {

        TextView tv_gia, tv_moTa, tv_ten;
        ImageView btn_gh_themMonAn;

        public monAnViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_gia = itemView.findViewById(R.id.tv_giaMonAn);
            tv_moTa = itemView.findViewById(R.id.tv_moTaMonAn);
            tv_ten = itemView.findViewById(R.id.tv_tenMonAn);
            btn_gh_themMonAn = itemView.findViewById(R.id.btn_gh_addMonAn);

        }
    }
}
