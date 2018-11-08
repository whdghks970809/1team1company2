package com.example.user.medicalpack;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<MyData> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button buttonOpen = (Button) findViewById(R.id.open);
        buttonOpen.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
                if (!drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.openDrawer(Gravity.LEFT);
                }
            }
        });

        Button buttonClose = (Button) findViewById(R.id.close) ;
        buttonClose.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer) ;
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT) ;
                }
            }
        });

        CheckBox checkboxLock = (CheckBox) findViewById(R.id.lock) ;
        checkboxLock.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer) ;
                if (((CheckBox)v).isChecked()) {
                    if (drawer.isDrawerOpen(Gravity.LEFT)) {
                        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                    } else {
                        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                    }
                } else {
                    drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                }
            }
        });

        super.

            onCreate(savedInstanceState);

            setContentView(R.layout.my_activity);

            mRecyclerView =(RecyclerView)

            findViewById(R.id.my_recycler_view);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager =new

            LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

            // specify an adapter (see also next example)
            mAdapter =new

            MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

            myDataset =new ArrayList<>();
            mAdapter =new

            MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        myDataset.add(new

            MyData("#InsideOut",R.mipmap.ic_launcher));
        myDataset.add(new

            MyData("#Mini",R.mipmap.ic_launcher_round));
        myDataset.add(new

            MyData("#ToyStroy",R.mipmap.ic_launcher_round));
        myDataset.add(new

            MyData("#Mini",R.mipmap.ic_launcher_round));

        }
    }
