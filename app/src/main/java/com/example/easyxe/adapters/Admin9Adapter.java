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
import com.example.easyxe.models.Users;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Admin9Adapter extends RecyclerView.Adapter<Admin9Adapter.myViewHolder> {

    private List<Users> mUsersList;
    private Context context;

    public Admin9Adapter(Context context, List<Users> userList)
    {
        this.context = context;
        this.mUsersList = userList;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_admin_9,viewGroup,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder myViewHolder, int i) {

        String image = mUsersList.get(i).getImage();
        String name = mUsersList.get(i).getName();
        String phone = mUsersList.get(i).getPhone();


        // set holder

        myViewHolder.mName.setText(name);
        myViewHolder.mPhone.setText(phone);
        try {
            Picasso.get().load(image)
                    .placeholder(R.drawable.image)
                    .into(myViewHolder.mUserImg);
        }catch (Exception e)
        {

        }

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
        return mUsersList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView mUserImg;
        private ImageView mExpand;
        private TextView mName;
        private TextView mPhone;
        private LinearLayout mllExpand;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            mUserImg = itemView.findViewById(R.id.ivUserImage);
            mName = itemView.findViewById(R.id.tvUserName);
            mPhone = itemView.findViewById(R.id.tvUserLocation);
            mExpand = itemView.findViewById(R.id.ivExpanse);

            mllExpand = itemView.findViewById(R.id.llExpand);
        }
    }
}
