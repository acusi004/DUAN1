package com.example.duan1.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.duan1.R;
import com.example.duan1.changePass;
import com.example.duan1.dangNhap;
import com.example.duan1.doanhThu;


public class caNhan_Fragment extends Fragment {



    TextView tv_changePass, tv_logOut, tv_doanhThu, tv_close;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_ca_nhan_, container, false);

        tv_close = view.findViewById(R.id.tv_if_exit);
        tv_logOut = view.findViewById(R.id.tv_if_logout);
        tv_changePass = view.findViewById(R.id.tv_if_changePass);
        tv_doanhThu = view.findViewById(R.id.tv_if_doanhThu);


        tv_logOut.setOnClickListener(v -> {
            Intent i = new Intent(getContext(), dangNhap.class);
            startActivity(i);
            getActivity().finish();
        });


        tv_changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), changePass.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        tv_close.setOnClickListener(v -> {
            getActivity().finish();
        });

        tv_doanhThu.setOnClickListener(v -> {
            Intent i = new Intent(getContext(), doanhThu.class);
            startActivity(i);
        });

        return view;
    }
}