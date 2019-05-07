package com.example.easyxe.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.easyxe.fragments.Fragment_Followers;
import com.example.easyxe.fragments.Fragment_Followings;
import com.example.easyxe.fragments.Fragment_Product;
import com.example.easyxe.fragments.Fragment_Rate;

public class PagerPersonalChild extends FragmentStatePagerAdapter {
    int tabCount;

    public PagerPersonalChild(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case  0:
                Fragment_Product fragment_product = new Fragment_Product();
                return fragment_product;
            case 1:
                Fragment_Rate fragment_rate = new Fragment_Rate();
                return fragment_rate;
            case 2:
                Fragment_Followers fragment_followers = new Fragment_Followers();
                return  fragment_followers;
            case 3:
                Fragment_Followings fragment_followings = new Fragment_Followings();
                return fragment_followings;
                default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
