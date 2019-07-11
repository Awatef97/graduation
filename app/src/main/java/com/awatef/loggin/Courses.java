package com.awatef.loggin;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.util.SortedList;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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

public class Courses extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    public static final String EXTRA_TEXT = "com.example.courses.EXTRA_TEXT";

    private Button button;
    List<String> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Courses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);

        //retrofit
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("//Link")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SpinnerApi spinnerApi=retrofit.create(SpinnerApi.class);
        Call<ResultModel> connection=spinnerApi.getItems();
        connection.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                items=response.body().getItems();
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {

            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.Courses);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.activity_main,R.id.Courses,items);
        // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.courses, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        /* open new activity  **/

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
    public interface SpinnerApi{
        @GET("file name .php")
        Call<ResultModel> getItems();
    }
    public class ResultModel{
        private List<String> items;
        public List<String> getItems(){
            return items;
        }
        public void  setItems(List<String> i){
            this.items=i;
        }
    }


}