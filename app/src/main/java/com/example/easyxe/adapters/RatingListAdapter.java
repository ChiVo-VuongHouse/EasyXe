package com.example.easyxe.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.easyxe.R;
import com.example.easyxe.models.Rating;

import java.util.List;


public class RatingListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Rating> mRatingList;

    public RatingListAdapter(Context mContext, List<Rating> mRatingList) {
        this.mContext = mContext;
        this.mRatingList = mRatingList;
    }

    @Override
    public int getCount() {
        return mRatingList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRatingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_item_rate, null);

        ImageView avatarRate = (ImageView)v.findViewById(R.id.avatarRate);
        RatingBar ratingRate = (RatingBar)v.findViewById(R.id.rating_rate);
        TextView textView_FullName = (TextView)v.findViewById(R.id.full_name);
        TextView textView_Report = (TextView)v.findViewById(R.id.report);

        // Set text for TextView
        textView_FullName.setText(mRatingList.get(position).getFullName());
        textView_Report.setText(mRatingList.get(position).getReport());
        // Set resource for ImageView
        avatarRate.setImageResource(mRatingList.get(position).getImageView());
        // Set rating for RatingBar
        ratingRate.setRating(mRatingList.get(position).getRatingValue());
        return v;
    }


}
