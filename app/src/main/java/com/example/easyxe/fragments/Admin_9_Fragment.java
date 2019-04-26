package com.example.easyxe.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyxe.adapters.Admin9Adapter;
import com.example.easyxe.R;
import com.example.easyxe.models.User;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_9_Fragment extends Fragment {
    private List<User> mData;

    public Admin_9_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_9, container, false);
        RecyclerView recyclerView1 = view.findViewById(R.id.rvAdmin9);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        Admin9Adapter admin9Adapter = new Admin9Adapter(getContext(),mData);
        recyclerView1.setAdapter(admin9Adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = new ArrayList<>();
        mData.add(new User("Hạ","Hà Nội","0121751","12, Nguyễn Trãi",R.drawable.image));
        mData.add(new User("Long","Thái Bình","012...51","12, Nguyễn Du",R.drawable.image2));
        mData.add(new User("Long","Thái Bình","012...51","12, Nguyễn Du",R.drawable.image2));
        mData.add(new User("Long","Thái Bình","012...51","12, Nguyễn Du",R.drawable.image2));
        mData.add(new User("Long","Thái Bình","012...51","12, Nguyễn Du",R.drawable.image2));
        mData.add(new User("Last item","Thái Bình","012...51","12, Nguyễn Du",R.drawable.image2));

    }
}
