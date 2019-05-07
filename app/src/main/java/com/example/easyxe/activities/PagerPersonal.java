package com.example.easyxe.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.easyxe.fragments.Fragment_Detail;
import com.example.easyxe.fragments.Fragment_Overview;

public class PagerPersonal extends FragmentStatePagerAdapter {
    int tabCount;

    public PagerPersonal(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case  0:
                Fragment_Overview fragment_overview = new Fragment_Overview();
                return fragment_overview;
            case 1:
                Fragment_Detail fragment_detail = new Fragment_Detail();
                return fragment_detail;
                default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
