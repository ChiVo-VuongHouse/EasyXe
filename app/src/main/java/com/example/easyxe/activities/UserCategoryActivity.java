package com.example.easyxe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.easyxe.R;

public class UserCategoryActivity extends AppCompatActivity {

    private ImageView motobike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_category);

        motobike = (ImageView)findViewById(R.id.motobike);
        motobike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserCategoryActivity.this, UserAddNewProductsActivity.class);
                intent.putExtra("category","motobike");
                startActivity(intent);
            }
        });

    }
}
