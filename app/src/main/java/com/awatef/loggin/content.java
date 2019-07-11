package com.awatef.loggin;

/**
 * Created by awatef on 6/29/2019.
 */


import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class content extends AppCompatActivity {
    private Button profile;
    private Button courses;
    private Button timetable;
    private Button news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);

        profile= (Button) findViewById(R.id.btnprofile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile();

            }
        });
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
    public  void profile ()
    {
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
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
        Intent intent = new Intent(this,Timetable.class);
        startActivity(intent);
    }
}