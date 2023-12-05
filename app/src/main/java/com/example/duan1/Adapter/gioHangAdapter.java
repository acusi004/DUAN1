package com.example.duan1.Adapter;

import static android.view.View.GONE;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.example.duan1.model.gioHang;
import com.example.duan1.model.monAn;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class gioHangAdapter extends RecyclerView.Adapter<gioHangAdapter.gioHangViewHolder> {

    ArrayList<gioHang> list;
    DbHelper dbHelper;
    Context context;
    private gioHangDAO ghDAO;

    private monAnDAO maDAO;

    gioHangAdapter ghAdapter;

    monAn ma;

    gioHang gh;



    public gioHangAdapter(ArrayList<gioHang> list, DbHelper dbHelper, Context context, gioHangDAO ghDAO) {
        this.list = list;
        this.dbHelper = dbHelper;
        this.context = context;
        this.ghDAO = ghDAO;
    }





    @NonNull
    @Override
    public gioHangAdapter.gioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rcv_gio_hang, parent, false);
        ghDAO = new gioHangDAO(context);
        ghAdapter = new gioHangAdapter(list, dbHelper, context, ghDAO);
        return new gioHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gioHangAdapter.gioHangViewHolder holder, int position) {
        gioHang gh = list.get(position);
        holder.tv_tenMon.setText(list.get(position).getTenMonAn());
        holder.tv_gia.setText(String.valueOf(list.get(position).getGia()+ " VND"));

        String img = list.get(position).getImg();
        Picasso.get().load(img).into(holder.iv_img_gh);



        int pricePlus = list.get(position).getGia();
        holder.iv_plus.setOnClickListener(v -> {
           int numberOrder = gh.getSoLuong()+1;
           int sum = (int) (pricePlus * numberOrder);
           holder.tv_soLuong.setText(String.valueOf(numberOrder));
           holder.tv_gia.setText(String.valueOf(sum)+ " VND");
           gh.setGia(sum);
           gh.setSoLuong(numberOrder);
           ghDAO.update(gh);
           updateListGioHang();
        });



        int priceMinus = list.get(position).getGia();
        holder.iv_minus.setOnClickListener(v -> {

            int numberOrder = gh.getSoLuong();

            if(numberOrder>1){
                numberOrder -= 1;
                int sum = (int) (priceMinus* numberOrder);
                holder.tv_soLuong.setText(String.valueOf(numberOrder));
                holder.tv_gia.setText(String.valueOf(sum)+ " VND");
                gh.setGia(sum);
                gh.setSoLuong(numberOrder);
                ghDAO.update(gh);

                // thuc hien hiển thị dữ liệu mới lên
                updateListGioHang();


            }else{
                Toast.makeText(context, "Số lượng không thể nhỏ hơn 1", Toast.LENGTH_SHORT).show();
            }


        });

        holder.itemView.setOnClickListener(v -> {
            Dialog dialog = new Dialog(v.getContext());
            dialog.setContentView(R.layout.dialog_item_delete_gio_hang);


            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            Button btn_co, btn_khong;

            btn_co = dialog.findViewById(R.id.item_dialog_delete_co);
            btn_khong = dialog.findViewById(R.id.item_dialog_delete_khong);

            btn_co.setOnClickListener(v1 -> {
                ghDAO = new gioHangDAO(context);
                int maGioHang = list.get(holder.getAdapterPosition()).getMaGioHang();
                boolean check = ghDAO.deleteGioHang(maGioHang);
                if(check){
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list = ghDAO.getAll();
                    notifyItemRemoved(holder.getAdapterPosition());
                    dialog.dismiss();
                }else{
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            });

            btn_khong.setOnClickListener(v12 -> {
                dialog.dismiss();
            });

            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class gioHangViewHolder extends RecyclerView.ViewHolder {

        TextView tv_tenMon, tv_soLuong, tv_gia;

        ImageView iv_plus, iv_minus, iv_img_gh;

        public gioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_gia = itemView.findViewById(R.id.tv_gh_gia);
            tv_soLuong = itemView.findViewById(R.id.tv_gh_soLuong);
            tv_tenMon = itemView.findViewById(R.id.tv_gh_tenMon);
            iv_plus = itemView.findViewById(R.id.plus);
            iv_minus = itemView.findViewById(R.id.minus);
            iv_img_gh = itemView.findViewById(R.id.iv_img_gh);
        }
    }




    public void updateListGioHang(){
        list.clear();
        list.addAll(ghDAO.getAll());
        ghAdapter.notifyDataSetChanged();
    }


}
