package com.awatef.loggin.ui;

/**
 * Created by awatef on 6/30/2019.
 */

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.widget.Adapter;
import android.widget.CheckBox;

import com.awatef.loggin.AttendanceAdapter;
import com.awatef.loggin.AttendanceTable;
import com.awatef.loggin.R;
import com.awatef.loggin.ResultTable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Attendence extends AppCompatActivity {

    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendence);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Attendance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);


        List<AttendanceTable> attendance =new ArrayList<>();
        attendance=getData();

        final RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //code of retrofit#####
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("end point")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AttendanceApi attendanceApi=retrofit.create(AttendanceApi.class);

        Call<ResultTable> connection =attendanceApi.getTable();
        connection.enqueue(new Callback<ResultTable>() {
            @Override
            public void onResponse(Call<ResultTable> call, Response<ResultTable> response) {
                List<AttendanceTable> attendance=response.body().getTable();
                AttendanceAdapter adapter=new AttendanceAdapter(attendance);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResultTable> call, Throwable t) {

            }
        });




    }
    private List<AttendanceTable> getData()
    {
        List<AttendanceTable> list=new ArrayList<>();
        list.add(new AttendanceTable("a",true,true,true));
        list.add(new AttendanceTable("asss",true,true,true));
        list.add(new AttendanceTable("afghj",false,true,true));


        return list;

    }
    public interface AttendanceApi {
        @GET("gettables.php")    // it must contain the file name of link
        Call<ResultTable> getTable();

    }

}
