package com.example.easyxe.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easyxe.R;
import com.example.easyxe.models.Followings;

import java.util.List;


public class FollowingsListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Followings> mFollowingsList;

    public FollowingsListAdapter(Context mContext, List<Followings> mFollowingsList) {
        this.mContext = mContext;
        this.mFollowingsList = mFollowingsList;
    }

    @Override
    public int getCount() {
        return mFollowingsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFollowingsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_item_followings, null);

        ImageView imageView_NameFollowings = (ImageView)v.findViewById(R.id.avatarFollowings);
        TextView textView_NameFollowings = (TextView)v.findViewById(R.id.followingsName);
        TextView textView_Address = (TextView)v.findViewById(R.id.Address);

        // Set text
        textView_NameFollowings.setText(mFollowingsList.get(position).getFollowingsName());
        textView_Address.setText(mFollowingsList.get(position).getAddress());

        // Set image
        imageView_NameFollowings.setImageResource(mFollowingsList.get(position).getImageFollowiings());

        return v;
    }
}
