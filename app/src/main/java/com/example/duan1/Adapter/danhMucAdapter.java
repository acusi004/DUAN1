package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



import com.example.duan1.R;
import com.example.duan1.manHinhChinh;
import com.example.duan1.model.danhMuc;

import java.util.ArrayList;

public class danhMucAdapter extends RecyclerView.Adapter<danhMucAdapter.danhMucViewHolder> {

    Context context;

    ArrayList<danhMuc> list;

    public danhMucAdapter(Context context, ArrayList<danhMuc> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public danhMucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((manHinhChinh)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_rcv_danh_muc, parent, false);
        return new danhMucViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull danhMucViewHolder holder, int position) {
        holder.iv_pic.setImageResource(list.get(position).getPicture());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class danhMucViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_pic;


        public danhMucViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_pic = itemView.findViewById(R.id.iv_danhMuc);

        }
    }
}
