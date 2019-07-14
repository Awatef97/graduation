package com.awatef.loggin.ui;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.awatef.loggin.CheckInternetConnection;
import com.awatef.loggin.List_Item;
import com.awatef.loggin.R;
import com.awatef.loggin.RecyclerViewAdapter;
import com.awatef.loggin.adapter.CourseAdapter;
import com.awatef.loggin.adapter.NewsAdapter;
import com.awatef.loggin.model.Course;
import com.awatef.loggin.model.New;
import com.awatef.loggin.model.Utilities;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class News extends AppCompatActivity {
    private NewsAdapter adapter;
    private RecyclerView newsRV;
    public ArrayList<New> news ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.news);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("News");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setTitleTextColor(Color.WHITE);
        super.onCreate(savedInstanceState);
        news = new ArrayList<>();

        newsRV =  findViewById(R.id.newsRV);
        adapter = new NewsAdapter(this, news);
        newsRV.setLayoutManager(new GridLayoutManager(this, 1));
        newsRV.setAdapter(adapter);
        getNews() ;
    }
    private void getNews() {
        Utilities.showLoadingDialog(this, Color.WHITE);

        FirebaseDatabase
                .getInstance()
                .getReference("news")
                .addChildEventListener(new ChildEventListener() {// listen to child
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String prevKey) {
                        Utilities.dismissLoadingDialog();

                        New recivedNew = dataSnapshot.getValue(New.class);
                        if (recivedNew != null) {
                            adapter.addNews(recivedNew);

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


