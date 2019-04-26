package com.example.easyxe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.easyxe.activities.MHDangKy;
import com.example.easyxe.activities.MHDangNhap;

public class DangXuat extends Fragment {
    private Button btnDangNhap;
    private Button btnDangKi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.dang_xuat,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Đăng xuất");




        btnDangNhap = (Button) view.findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MHDangNhap.class);
                startActivity(intent);
            }
        });

        btnDangKi = (Button) view.findViewById(R.id.btnDangKy);
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MHDangKy.class);
                startActivity(intent);
            }
        });

    }

}
