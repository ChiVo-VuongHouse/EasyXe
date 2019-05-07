package com.example.easyxe.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.easyxe.R;
import com.example.easyxe.fragments.DashboardExpired;
import com.example.easyxe.fragments.DashboardOutofProducts;
import com.example.easyxe.fragments.DashboardSelling;
import com.example.easyxe.fragments.NotifFollowers;
import com.example.easyxe.fragments.NotifFollowings;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class NotifPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.notif_tab_text_1, R.string.notif_tab_text_2};
    private final Context mContext;

    public NotifPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new NotifFollowings();
                break;
            case 1:
                fragment = new NotifFollowers();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}