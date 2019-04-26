package com.example.easyxe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easyxe.R;
import com.example.easyxe.fragments.Admin_8_Fragment;
import com.example.easyxe.fragments.Admin_9_Fragment;
import com.example.easyxe.models.User;

import java.util.ArrayList;
import java.util.List;

public class AdminMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    List<User> mData;
    ImageView mAdImg;
    TextView mAdName;
    TextView mAdPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //bottom nav

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        View header = navigationView.getHeaderView(0);

        mAdImg = header.findViewById(R.id.ivAdminAvatar);
        mAdName = header.findViewById(R.id.tvAdminName);
        mAdPhone = header.findViewById(R.id.tvAdminPhone);


        mData = new ArrayList<>();
        mData.add(new User("Admin 1","Hạ Long","012112121","45 Lâm Thạnh",R.drawable.image2));

        mAdName.setText(mData.get(0).getmUserName());
        mAdImg.setImageResource(mData.get(0).getmImage());
        mAdPhone.setText(mData.get(0).getmUserPhone());




    }




    public void ini()
    {
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //drawer
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_admin_setting) {
            //chuyển dữ liệu
            Intent intent = new Intent(getApplication(),Screen19Activity.class);
            intent.putParcelableArrayListExtra("data",(ArrayList) mData);
            startActivity(intent);


        } else if (id == R.id.nav_change_admin_password) {

        } else if (id == R.id.nav_admin_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //bottom navigation

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    getSupportActionBar().setTitle(R.string.admin_title_home);
                    break;
                case R.id.nav_notifi:
                    getSupportActionBar().setTitle(R.string.admin_title_notifi);
                    fragment = new Admin_8_Fragment();
                    break;
                case R.id.nav_person:
                    getSupportActionBar().setTitle(R.string.admin_title_person);
                    fragment = new Admin_9_Fragment();
                    break;
                case R.id.nav_more:
                    getSupportActionBar().setTitle(R.string.admin_title_more);
                    break;
            }
            loadFragment(fragment);
            return true;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flAdminContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
