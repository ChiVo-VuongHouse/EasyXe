package com.example.easyxe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.easyxe.R;
import com.example.easyxe.models.Followers;

import java.util.List;


public class FollowersListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Followers> mFollowerslist;

    public FollowersListAdapter(Context mContext, List<Followers> mFollowerslist) {
        this.mContext = mContext;
        this.mFollowerslist = mFollowerslist;
    }

    @Override
    public int getCount() {
        return mFollowerslist.size();
    }

    @Override
    public Object getItem(int position) {
        return mFollowerslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_item_followers, null);

        ImageView imageView_Followers = (ImageView)v.findViewById(R.id.avatarFollowers);
        TextView textView_Followers = (TextView)v.findViewById(R.id.followersName);

        // Set text for textview
        textView_Followers.setText(mFollowerslist.get(position).getFollowersName());

        // Set resource for imageView
        imageView_Followers.setImageResource(mFollowerslist.get(position).getImageFollowers());


        return v;
    }
}
