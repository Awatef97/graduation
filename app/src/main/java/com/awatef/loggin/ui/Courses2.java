package com.awatef.loggin.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.awatef.loggin.R;
import com.awatef.loggin.Scanqr;

//import static com.awatef.loggin.R.layout.courses2;

/**
 * Created by awatef on 6/30/2019.
 */


    public class Courses2 extends AppCompatActivity {
        public static  final String EXTRA ="com.example.courses.EXTRA";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.courses2);

            Intent intent =getIntent();
            //String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);



            Toolbar toolbar= (Toolbar) findViewById(R.id.my_toolbar2);
            setSupportActionBar(toolbar);
            //getSupportActionBar().setTitle(text);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setTitleTextColor(Color.WHITE);


            // code of material button
            Button material= (Button) findViewById(R.id.material);
            material.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    materialActivity();
                }
            });

            Button grade= (Button) findViewById(R.id.grades);
            grade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gradeActivity();
                }
            });
            Button attendence= (Button) findViewById(R.id.attendances);
            attendence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AttendenceActivity();
                }
            });
            Button teamwork= (Button) findViewById(R.id.team_work);

            Button scanqr= (Button) findViewById(R.id.scan_qr);
            scanqr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scanqrActivity();
                }
            });
        }
        public void materialActivity(){
          //  Intent intent=new Intent(this,Materials.class);

            Intent intent1 =getIntent();
           /* String text = intent1.getStringExtra(MainActivity.EXTRA_TEXT);
            intent.putExtra(EXTRA,text);
            startActivity(intent);*/
        }
    public void gradeActivity(){
        Intent intent=new Intent(this,Grade.class);

        Intent intent1 =getIntent();
        //String text = intent1.getStringExtra(MainActivity.EXTRA_TEXT);
        //intent.putExtra(EXTRA,text);
        startActivity(intent);
    }
    public void AttendenceActivity(){
        Intent intent=new Intent(this,Attendence.class);

        Intent intent1 =getIntent();
       // String text = intent1.getStringExtra(MainActivity.EXTRA_TEXT);
        //intent.putExtra(EXTRA,text);
        startActivity(intent);
    }
       public void scanqrActivity(){
        Intent intent=new Intent(this, Scanqr.class);

        Intent intent1 =getIntent();
        //String text = intent1.getStringExtra(MainActivity.EXTRA_TEXT);
       // intent.putExtra(EXTRA,text);
        startActivity(intent);
    }
    }

