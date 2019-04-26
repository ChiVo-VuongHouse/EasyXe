package com.example.easyxe.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.easyxe.R;
import com.example.easyxe.models.User;

import java.util.List;

public class Admin9Adapter extends RecyclerView.Adapter<Admin9Adapter.myViewHolder> {

    private List<User> mUserList;
    private Context context;

    public Admin9Adapter(Context context, List<User> userList)
    {
        this.context = context;
        this.mUserList = userList;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_admin_9,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder myViewHolder, int i) {

        myViewHolder.mUserImg.setImageResource(mUserList.get(i).getmImage());
        myViewHolder.mName.setText(mUserList.get(i).getmUserName());
        myViewHolder.mCity.setText(mUserList.get(i).getmUserCity());

        myViewHolder.mExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myViewHolder.mllExpand.getVisibility() == View.GONE)
                {
                    myViewHolder.mllExpand.setVisibility(View.VISIBLE);
                    myViewHolder.mExpand.animate().rotation(180).start();
                    //myViewHolder.mExpand.setImageResource(R.drawable.ic_expand_less_black_24dp);
                }else
                {
                    myViewHolder.mllExpand.setVisibility(View.GONE);
                    myViewHolder.mExpand.animate().rotation(0).start();
                    //myViewHolder.mExpand.setImageResource(R.drawable.ic_expand_more_black_24dp);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView mUserImg;
        private ImageView mExpand;
        private TextView mName;
        private TextView mCity;
        private LinearLayout mllExpand;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            mUserImg = itemView.findViewById(R.id.ivUserImage);
            mName = itemView.findViewById(R.id.tvUserName);
            mCity = itemView.findViewById(R.id.tvUserLocation);
            mExpand = itemView.findViewById(R.id.ivExpanse);

            mllExpand = itemView.findViewById(R.id.llExpand);
        }
    }
}
