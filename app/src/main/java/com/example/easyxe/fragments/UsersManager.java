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
import com.example.easyxe.models.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsersManager extends Fragment {
    private  List<Users> userList;
    private RecyclerView recyclerView1;
    private Admin9Adapter admin9Adapter;

    public UsersManager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_9, container, false);
        recyclerView1 = view.findViewById(R.id.rvAdmin9);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));

        userList = new ArrayList<>();
        getAllUser();

        return view;
    }

    private void getAllUser() {
        //get current user
        final FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        //get path of data names
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    Users users = ds.getValue(Users.class);
//                    if (!users.getPhone().equals(mUser.getPhoneNumber())) {
//                        userList.add(users);
//                    }
                    userList.add(users);
                    admin9Adapter = new Admin9Adapter(getActivity(),userList);
                    recyclerView1.setAdapter(admin9Adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
