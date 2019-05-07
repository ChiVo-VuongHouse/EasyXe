package com.example.easyxe.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.easyxe.R;
import com.example.easyxe.adapters.CustomExpandableListView;
import com.example.easyxe.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MoreFragment extends Fragment {
    ExpandableListView listView;
    List<String> listdataHeader;
    HashMap<String, List<String>> listHash;
    CustomExpandableListView listAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotifFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotifFragment newInstance(String param1, String param2) {
        NotifFragment fragment = new NotifFragment();
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
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        getActivity().setTitle("Chức năng khác");
        listView = (ExpandableListView)view.findViewById(R.id.expandableListView);
        initData();


        listAdapter = new CustomExpandableListView(getActivity(), listdataHeader, listHash);
        listView.setAdapter(listAdapter);
        return view;


    }

    private void initData(){
        listdataHeader = new ArrayList<>();
        listHash = new HashMap<String, List<String>>();

        listdataHeader.add("Phiên bản");
        listdataHeader.add("Liên hệ");
        listdataHeader.add("Báo cáo sự cố");

        List<String> phienban = new ArrayList<String>();
        phienban.add("v.0.1");

        List<String> lienhe = new ArrayList<String>();
        lienhe.add("Phone Number");
        lienhe.add("Messenger");

        List<String> baocao = new ArrayList<String>();

        listHash.put(listdataHeader.get(0), phienban);
        listHash.put(listdataHeader.get(1), lienhe);
        listHash.put(listdataHeader.get(2), baocao);
    }

}
