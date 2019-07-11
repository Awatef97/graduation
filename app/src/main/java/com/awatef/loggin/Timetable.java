package com.awatef.loggin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by awatef on 6/30/2019.
 */

public class Timetable extends AppCompatActivity implements  AdapterView.OnItemSelectedListener  {

    public static final String EXTRA_TEXT = "com.example.timetable.EXTRA_TEXT";

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Time Table");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);


        Spinner spinner = (Spinner)findViewById(R.id.Courses);
// Create an ArrayAdapter using the string array and a default spinner layout
     /*   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array., android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/

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
    public void   openActivity2 (){


        Intent intent = new Intent(this, Timetable1.class);

        Spinner spinner = (Spinner)findViewById(R.id.Courses);
        String text = spinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);


    }
}
