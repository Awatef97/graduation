package com.awatef.loggin.ui;

/**
 * Created by awatef on 6/30/2019.
 */

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.widget.Adapter;
import android.widget.CheckBox;

import com.awatef.loggin.AttendanceAdapter;
import com.awatef.loggin.AttendanceTable;
import com.awatef.loggin.R;
import com.awatef.loggin.ResultTable;
import com.awatef.loggin.adapter.AttendenceAdapter;
import com.awatef.loggin.adapter.NewsAdapter;
import com.awatef.loggin.model.New;
import com.awatef.loggin.model.User;
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

public class Attendence extends AppCompatActivity {
    private AttendenceAdapter adapter;
    private RecyclerView attendenceRV;
    public ArrayList<User> users ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendence);


        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Attendance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        users = new ArrayList<>();
        attendenceRV =  findViewById(R.id.attendenceRV);
        adapter = new AttendenceAdapter(this, users);
        attendenceRV.setLayoutManager(new GridLayoutManager(this, 1));
        attendenceRV.setAdapter(adapter);
        getUsers();
    }
    private void getUsers() {
        Utilities.showLoadingDialog(this, Color.WHITE);

        FirebaseDatabase
                .getInstance()
                .getReference("users")
                .addChildEventListener(new ChildEventListener() {// listen to child
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String prevKey) {
                        Utilities.dismissLoadingDialog();

                        User user = dataSnapshot.getValue(User.class);
                        if (user != null) {
                            if(user.getType().equals("Student")) {
                                adapter.addUsers(user);
                            }
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
