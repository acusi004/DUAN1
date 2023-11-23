package com.example.duan1.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class donHangAdapter extends RecyclerView.Adapter<donHangAdapter.hoaDonViewHolder> {
    @NonNull
    @Override
    public donHangAdapter.hoaDonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull donHangAdapter.hoaDonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class hoaDonViewHolder extends RecyclerView.ViewHolder {
        public hoaDonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
