package com.example.duan1.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class lichSuAdapter extends RecyclerView.Adapter<lichSuAdapter.lichSuViewHolder> {
    @NonNull
    @Override
    public lichSuAdapter.lichSuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull lichSuAdapter.lichSuViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class lichSuViewHolder extends RecyclerView.ViewHolder {
        public lichSuViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
