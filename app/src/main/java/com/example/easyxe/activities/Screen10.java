package com.example.easyxe.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.easyxe.R;
import com.example.easyxe.adapters.CustomExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Screen10 extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listdataHeader;
    HashMap<String, List<String>> listDataChild;
    CustomExpandableListView customExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen10);
        addControl();
        customExpandableListView = new CustomExpandableListView(Screen10.this, listdataHeader, listDataChild);

        expandableListView.setAdapter(customExpandableListView);

        Click_group();
        Clicl_child();
        Close_group();
        Open_group();
    }

    private void Open_group() {
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(Screen10.this, listdataHeader.get(groupPosition) + "Open", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Close_group() {
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(Screen10.this, listdataHeader.get(groupPosition) + "Close", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Clicl_child() {
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long l) {
                Toast.makeText(Screen10.this, listDataChild.get(listdataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void Click_group() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long l) {
                Toast.makeText(Screen10.this, listdataHeader.get(groupPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void addControl() {
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        listdataHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<String>>();

        listdataHeader.add("Phiên bản");
        listdataHeader.add("Liên hệ");
        listdataHeader.add("Báo cáo sự cố");

        List<String> phienban = new ArrayList<String>();
        phienban.add("v.0.1");

        List<String> lienhe = new ArrayList<String>();
        lienhe.add("Phone Number");
        lienhe.add("Messenger");

        List<String> baocao = new ArrayList<String>();

        listDataChild.put(listdataHeader.get(0), phienban);
        listDataChild.put(listdataHeader.get(1), lienhe);
        listDataChild.put(listdataHeader.get(2), baocao);
    }
}
