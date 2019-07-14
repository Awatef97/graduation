package com.awatef.loggin.ui;

/**
 * Created by awatef on 6/29/2019.
 */

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
import android.widget.ImageView;

import com.awatef.loggin.R;
import com.google.firebase.auth.FirebaseAuth;

public class content extends AppCompatActivity {
    private Button profile;
    private Button courses;
    private Button timetable;
    private Button news;
    private ImageView logoutIV;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);

        Toolbar toolbar =  findViewById(R.id.my_toolbar);
         logoutIV =  toolbar.findViewById(R.id.logoutIV);
        auth = FirebaseAuth.getInstance();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        logoutIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(content.this)
                        .setTitle("Logout")
                        .setMessage("Are you sure")
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                auth.signOut();
                                Intent intent = new Intent(content.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }).show();
            }
        });

        profile= (Button) findViewById(R.id.btnprofile);
        courses= (Button) findViewById(R.id.btncourses);
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courses();
            }
        });
        news= (Button) findViewById(R.id.btnnews);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                news();

            }
        });
        timetable= (Button) findViewById(R.id.btntable);
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timetable();

            }
        });
    }

    public  void courses ()
    {
        Intent intent = new Intent(this,Courses.class);
        startActivity(intent);
    }
    public  void news ()
    {
        Intent intent = new Intent(this,News.class);
        startActivity(intent);
    }
    public  void timetable ()
    {
        Intent intent = new Intent(this,Timetable1.class);
        startActivity(intent);
    }
}