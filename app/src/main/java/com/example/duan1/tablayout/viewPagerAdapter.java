package com.example.duan1.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1.fragment.burgerFragment;
import com.example.duan1.fragment.nuocUongFragment;
import com.example.duan1.fragment.pizzaFragment;
import com.example.duan1.fragment.trangChu_Fragment;

public class viewPagerAdapter extends FragmentStateAdapter {


    public viewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new burgerFragment();

            case 1: return new pizzaFragment();

            case 2: return new nuocUongFragment();

            default: return new burgerFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
