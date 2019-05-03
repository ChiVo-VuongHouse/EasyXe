package com.example.easyxe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easyxe.R;

public class MHDangKy extends AppCompatActivity {

    private  Button btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_ki);
        btnHuy = (Button) findViewById(R.id.btn_cancel);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MHDangKy.this, LogoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
