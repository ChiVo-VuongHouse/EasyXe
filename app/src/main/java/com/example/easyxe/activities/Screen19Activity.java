package com.example.easyxe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.easyxe.R;
import com.example.easyxe.models.User;

import java.util.List;


public class Screen19Activity extends AppCompatActivity {
    Button btnOK;
    List<User> mData;
    TextInputEditText mAdName;
    TextInputEditText mAdAdress;
    TextInputEditText mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen19);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.toolbar_title_19);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_chevron_left_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getBundleData();

    }

    public void getBundleData()
    {
        btnOK = findViewById(R.id.btnOK);
        mAdName = findViewById(R.id.etName);
        mAdAdress = findViewById(R.id.etAddress);
        mPhone = findViewById(R.id.etPhone);


        Intent intent = getIntent();
        mData = intent.getParcelableArrayListExtra("data");
        if (mData!=null)
        {
            mAdName.setText(mData.get(0).getmUserName());
            mAdAdress.setText(mData.get(0).getmUserLocation());

            mPhone.setText(mData.get(0).getmUserPhone());
        }else
        {
            mAdName.setText("k data");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.screen19_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_bar_cart:
                Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
