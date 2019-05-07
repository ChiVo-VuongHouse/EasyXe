package com.example.easyxe.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.easyxe.adapters.CustomListAdapter;
import com.example.easyxe.models.Product;
import com.example.easyxe.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listProducts;

    String[] strsLoaiXe = {"Xe máy", "Xe hơi", "Xe tải", "Xe motor"};
    String[] strsGia = {"Thấp -> cao", "Cao -> thấp", "Phổ biến"};
    String[] strsDiaDiem = {"Hà Nội", "TP. Hồ Chí Minh"};
    List<String> listLoaiXe = new ArrayList<String>(Arrays.asList(strsLoaiXe));
    Spinner spinLoaiXe, spinDiaDiem, spinGia;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getActivity().setTitle("Home");

        spinLoaiXe = (Spinner) view.findViewById(R.id.spinLoaiXe);
        spinDiaDiem = (Spinner) view.findViewById(R.id.spinDiaDiem);
        spinGia = (Spinner) view.findViewById(R.id.spinGia);

        ArrayAdapter dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strsLoaiXe);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLoaiXe.setAdapter(dataAdapter);
        dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strsDiaDiem);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDiaDiem.setAdapter(dataAdapter);
        dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, strsGia);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinGia.setAdapter(dataAdapter);

        listProducts = (ListView) view.findViewById(R.id.listProducts);

        Product product1 = new Product(1, "Xe 67 zin", 26000000.0, "Hà Nội", "Thắng", R.mipmap.xe_67);
        Product product2 = new Product(2, "Xe SuperDream", 26000000.0, "Hà Nội", "Thắng", R.mipmap.airblade);
        Product product3 = new Product(3, "AirBlade", 26000000.0, "TP. Hồ Chí Minh", "Nhựt", R.mipmap.superdream);

        Product[] products = new Product[]{product1, product2, product3};

//        ArrayAdapter<Product> arrayAdapter =
//                new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, products);


        List<Product> arrayList = new ArrayList<>();
        arrayList.add(product1);
        arrayList.add(product2);
        arrayList.add(product3);
        CustomListAdapter adapter =
                new CustomListAdapter(getActivity(), arrayList);
        listProducts.setAdapter(adapter);

        return view;
    }


}
