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

import com.example.easyxe.adapters.Admin8Adapter;
import com.example.easyxe.models.Product;
import com.example.easyxe.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_8_Fragment extends Fragment {
    private List<Product> mData;

    public Admin_8_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_8,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.rvAdmin8);
        recyclerView.setHasFixedSize(true);
        Admin8Adapter admin8Adapter = new Admin8Adapter(getContext(),mData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(admin8Adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = new ArrayList<>();
        mData.add(new Product(1521,"Honda giá rẻ",25000.7,"Hà Nội","Mr. Nam",R.drawable.image));
        mData.add(new Product(1521,"Honda giá rẻ",17000.0,"Hà Nội","Mr. Nam",R.drawable.image));
        mData.add(new Product(1521,"Honda giá rẻ",17000.0,"Hà Nội","Mr. Nam",R.drawable.image));
        mData.add(new Product(1521,"Honda giá rẻ",17000.0,"Hà Nội","Mr. Nam",R.drawable.image));
        mData.add(new Product(1521,"Honda giá rẻ",17000.0,"Hà Nội","Mr. Nam",R.drawable.image));
        mData.add(new Product(1521,"Honda giá rẻ",17000.0,"Hà Nội","Mr. Nam",R.drawable.image));
        mData.add(new Product(1521,"Honda giá rẻ",17000.0,"Hà Nội","Mr. Nam",R.drawable.image));
        mData.add(new Product(1521,"Last item",17000.0,"Hà Nội","Mr. Nam",R.drawable.image));



        //app:layout_constraintBottom_toBottomOf="parent"


    }
}
