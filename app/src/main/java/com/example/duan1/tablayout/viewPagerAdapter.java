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

import java.util.ArrayList;
import java.util.List;

public class viewPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }


    public viewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
     return fragmentList.get(position);

    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }


}
