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
import com.example.easyxe.adapters.FollowersListAdapter;
import com.example.easyxe.models.Followers;

import java.util.ArrayList;
import java.util.List;



public class Fragment_Followers extends Fragment {
    private ListView lvFollowers;
    private FollowersListAdapter adapter;
    private List<Followers> mFollowersList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_followers, container, false);

        lvFollowers = (ListView) view.findViewById(R.id.listViewFollowers);
        mFollowersList = new ArrayList<>();

        mFollowersList.add(new Followers(1, "Medeline Kennedy"));

        adapter = new FollowersListAdapter(getActivity().getApplicationContext(), mFollowersList);
        lvFollowers.setAdapter(adapter);

        return view;
    }
}
