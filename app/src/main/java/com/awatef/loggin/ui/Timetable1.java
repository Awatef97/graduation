package com.awatef.loggin.ui;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ImageView;

import com.awatef.loggin.R;

/**
 * Created by awatef on 7/1/2019.
 */

public class Timetable1 extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable1);

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Time Table");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
}}
