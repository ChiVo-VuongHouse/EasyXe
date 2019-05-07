package com.example.easyxe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easyxe.R;

public class ChangePassword extends AppCompatActivity {
    Button btnXong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password1);

        // Thanh ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        btnXong = (Button) findViewById(R.id.btnXong);
//        btnXong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent screen3 = new Intent(ChangePassword.this, PasswordRetrieval.class);
//                startActivity(screen3);
//            }
//        });
    }
}
