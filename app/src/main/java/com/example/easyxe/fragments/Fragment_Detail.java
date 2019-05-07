package com.example.easyxe.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.easyxe.R;
import com.example.easyxe.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fragment_Detail extends Fragment {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabdetail, container, false);
        listView = (ExpandableListView)view.findViewById(R.id.elvDetails);
        initData();



        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);
        return view;
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Tên hiển thị: Dân bán chuyên nghiệp ");
        listDataHeader.add("Số điện thoại: 0912345678");
        listDataHeader.add("Đỉa chỉ: Hà Nội");
        listDataHeader.add("Email: danbanchuyennghiep@gmail.com");
        listDataHeader.add("Ngày sinh: 16/06/1996");
        listDataHeader.add("Giới tính: Nam");
        listDataHeader.add("Facebook");
        listDataHeader.add("Báo cáo vi phạm");



        List<String> name = new ArrayList<>();


        List<String> phone = new ArrayList<>();
        phone.add("0912345678");

        List<String> address = new ArrayList<>();
        address.add("Hà Nội");

        List<String> email = new ArrayList<>();
        email.add("danbanchuyennghiep@gmail.com");

        List<String> birth = new ArrayList<>();

        List<String> sex = new ArrayList<>();

        List<String> facebook = new ArrayList<>();
        facebook.add("Sang Nguyen");

        List<String> report = new ArrayList<>();
        report.add("abcxyz");

        listHash.put(listDataHeader.get(0), name);
        listHash.put(listDataHeader.get(1), phone);
        listHash.put(listDataHeader.get(2), address);
        listHash.put(listDataHeader.get(3), email);
        listHash.put(listDataHeader.get(4), birth);
        listHash.put(listDataHeader.get(5), sex);
        listHash.put(listDataHeader.get(6), facebook);
        listHash.put(listDataHeader.get(7), report);
    }

    public void onWindowFocusChanged(boolean hasFocus){

    }


}
