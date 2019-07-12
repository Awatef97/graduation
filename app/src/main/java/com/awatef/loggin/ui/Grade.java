package com.awatef.loggin.ui;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.awatef.loggin.GradeAdapter;
import com.awatef.loggin.GradeTable;
import com.awatef.loggin.R;
import com.awatef.loggin.ResultTable1;
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
public class Grade extends AppCompatActivity {

    GradeAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Grades");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        // code of recycler view
        List<GradeTable> grades =new ArrayList<>();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(Grade.this));

        //code of retrofit
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("end point")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GradesApi gradesApi=retrofit.create(GradesApi.class);

        Call<ResultTable1> connection =gradesApi.getTable();
        connection.enqueue(new Callback<ResultTable1>() {
            @Override
            public void onResponse(Call<ResultTable1> call, Response<ResultTable1> response) {
                List<GradeTable> grades=response.body().getTable();
                adapter=new GradeAdapter(grades,getApplication());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResultTable1> call, Throwable t) {

            }
        });




        //

    }

    // create interface for using retrofit

    public interface GradesApi {
        @GET("gettables.php")    // it must contain the file name of link
        Call<ResultTable1> getTable();

    }
}