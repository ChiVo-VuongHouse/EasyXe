package com.example.easyxe.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.easyxe.R;
import com.example.easyxe.adapters.RatingListAdapter;
import com.example.easyxe.models.Rating;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Rate extends Fragment {
    private ListView lvRating;
    private RatingListAdapter adapter;
    private List<Rating> mRatingList;

    LinearLayout layout_rating_edit;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate, container, false);

        lvRating = (ListView)view.findViewById(R.id.listViewRating);
        mRatingList = new ArrayList<>();

        //Add
        mRatingList.add(new Rating(1, 5, "Messi", "nhân viên nhiệt tính"));
        mRatingList.add(new Rating(2, (float)3.25, "Ronaldo", "shipper nhanh gọn"));
        mRatingList.add(new Rating(3, 1, "Mbappe", "chủ thân thiện"));
        mRatingList.add(new Rating(4, 2, "Hazard", "sản phẩm chất lượng"));
        mRatingList.add(new Rating(5, 4, "Suarez", "chất lượng sản phẩm chưa được tốt"));
        mRatingList.add(new Rating(6, 2, "Lukaku", "cho 5 sao"));

        //
        // layout_rating_edit = (LinearLayout)view.findViewById(R.id.layout_rating_edit);
        // layout_rating_edit.setVisibility(LinearLayout.GONE);


        //
        adapter = new RatingListAdapter(getActivity().getApplicationContext(), mRatingList);
        lvRating.setAdapter(adapter);


        return view;
    }


}
