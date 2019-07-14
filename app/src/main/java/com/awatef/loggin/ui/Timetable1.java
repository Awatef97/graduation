package com.awatef.loggin.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;

import com.awatef.loggin.R;
import com.awatef.loggin.adapter.NewsAdapter;
import com.awatef.loggin.adapter.SubjectTableAdapter;
import com.awatef.loggin.model.New;
import com.awatef.loggin.model.SubjectTable;

import java.util.ArrayList;

/**
 * Created by awatef on 7/1/2019.
 */

public class Timetable1 extends AppCompatActivity implements SubjectTableAdapter.OnsubjectTableNameTVClickListener {
    private SubjectTableAdapter adapter;
    private RecyclerView subjectTableRV;
    public ArrayList<SubjectTable> subjectTables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable1);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Time Table");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setTitleTextColor(Color.WHITE);
        subjectTables = new ArrayList<>();
        subjectTables.add(new SubjectTable("الفرقة الاولى ", R.drawable.one));
        subjectTables.add(new SubjectTable("الفرقة الثانية ", R.drawable.two));
        subjectTables.add(new SubjectTable("الفرقة الثالثة علوم حاسب ", R.drawable.three));
        subjectTables.add(new SubjectTable("الفرقة الثالثة نظم المعلومات ", R.drawable.threeis));
        subjectTables.add(new SubjectTable("الفرقة الرابعة علوم حاسب ", R.drawable.four));
        subjectTables.add(new SubjectTable("الفرقة الرابعة نظم المعلومات ", R.drawable.four_is));

        subjectTableRV =  findViewById(R.id.subjectTableRV);
        adapter = new SubjectTableAdapter(this, subjectTables ,this);
        subjectTableRV.setLayoutManager(new GridLayoutManager(this, 1));
        subjectTableRV.setAdapter(adapter);

    }

    @Override
    public void onsubjectTableNameTVClick(SubjectTable subjectTable) {
        Intent i = new Intent(this, TableSubjectActivity.class);
        i.putExtra("sampleObject", subjectTable);
        startActivity(i);
    }
}
