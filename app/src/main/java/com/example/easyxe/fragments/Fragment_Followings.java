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
import com.example.easyxe.adapters.FollowingsListAdapter;
import com.example.easyxe.models.Followings;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Followings extends Fragment {
    private ListView lvFollowings;
    private FollowingsListAdapter adapter;
    private List<Followings> mFollowingsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_followings, container, false);

        lvFollowings = (ListView)view.findViewById(R.id.listViewFollowings);
        mFollowingsList = new ArrayList<>();

        mFollowingsList.add(new Followings(1, "Madeline Kennedy", "Hà Nội"));
        mFollowingsList.add(new Followings(2, "Chris Evans", "NA"));
        mFollowingsList.add(new Followings(3, "Tom Holland", "UK"));
        mFollowingsList.add(new Followings(4, "anh Phương", "Bắc Ninh"));


        adapter = new FollowingsListAdapter(getActivity().getApplicationContext(), mFollowingsList);
        lvFollowings.setAdapter(adapter);

        return view;
    }
}
