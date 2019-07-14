package com.awatef.loggin.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.awatef.loggin.GradeTable;
import com.awatef.loggin.R;
import com.awatef.loggin.adapter.GradeAdapter;
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

/**
 * Created by awatef on 6/30/2019.
 */
public class Grade extends AppCompatActivity {


    private GradeAdapter adapter;
    private RecyclerView recyclerView;
    public ArrayList<User> users ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Grades");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        users = new ArrayList<>();
        recyclerView =  findViewById(R.id.recyclerView);
        adapter = new GradeAdapter(this, users);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(adapter);
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