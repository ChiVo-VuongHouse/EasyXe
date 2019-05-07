package com.example.easyxe.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.easyxe.R;
import com.example.easyxe.adapters.ProductListAdapter;
import com.example.easyxe.models.Products;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Product extends Fragment {
    private ListView lvProducts;
    private ProductListAdapter adapter;
    private List<Products> mProductList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        lvProducts = (ListView)view.findViewById(R.id.listViewProduct);
        mProductList = new ArrayList<>();

        //Add
        mProductList.add(new Products(1, "Lamboghini", 200000000));
        mProductList.add(new Products(2, "Ferrari", 200000000));
        mProductList.add(new Products(3, "Porsche", 200000000));
        mProductList.add(new Products(4, "Harley Davidson", 200000000));


        adapter = new ProductListAdapter(getActivity().getApplicationContext(), mProductList);
        lvProducts.setAdapter(adapter);

        return view;
    }
}
