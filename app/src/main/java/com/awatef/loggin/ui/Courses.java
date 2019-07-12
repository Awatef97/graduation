package com.awatef.loggin.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.awatef.loggin.R;
import com.awatef.loggin.adapter.CourseAdapter;
import com.awatef.loggin.model.Course;
import com.awatef.loggin.model.Utilities;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by awatef on 6/30/2019.
 */

public class Courses extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_TEXT = "com.example.courses.EXTRA_TEXT";
    private CourseAdapter adapter;

    private Button button;
    private RecyclerView coursesRV;

    public ArrayList<Course> courses ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        courses = new ArrayList<>();
        getSupportActionBar().setTitle("Courses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        coursesRV = (RecyclerView) findViewById(R.id.coursesRV);
        adapter = new CourseAdapter(this, courses);
        coursesRV.setLayoutManager(new GridLayoutManager(this, 1));
        coursesRV.setAdapter(adapter);


        /* open new activity  **/
        getCourses();

        button = (Button) findViewById(R.id.ok);
        button.setTextColor(Color.WHITE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openActivity2() {
        Intent intent = new Intent(this, Courses2.class);
        Spinner spinner = (Spinner) findViewById(R.id.Courses);
        String text = spinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }

    private void getCourses() {
        Utilities.showLoadingDialog(this, Color.WHITE);

        FirebaseDatabase
                .getInstance()
                .getReference("courses")
                .addChildEventListener(new ChildEventListener() {// listen to child
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String prevKey) {
                        Utilities.dismissLoadingDialog();

                        Course course = dataSnapshot.getValue(Course.class);
                        if (course != null) {
                            adapter.addCourse(course);

                        }
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {


                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override

                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("ListenerCourses", "Error");
                    }
                });
    }

}