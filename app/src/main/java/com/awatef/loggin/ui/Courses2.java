package com.awatef.loggin.ui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.awatef.loggin.R;
import com.awatef.loggin.Scanqr;
import com.awatef.loggin.model.Course;
import com.awatef.loggin.model.SubjectTable;
import com.awatef.loggin.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import static com.awatef.loggin.R.layout.courses2;



    public class Courses2 extends AppCompatActivity {
       public Course course ;
        private FirebaseAuth mAuth;
        private User recievedUser;
        Button scanqr ;
        TextView scan_qr_text ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.courses2);

            Intent intent =getIntent();
             course = (Course) intent.getSerializableExtra("sampleObject");
            Toolbar toolbar=  findViewById(R.id.my_toolbar2);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(course.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setTitleTextColor(Color.WHITE);

            // code of material button
            Button material=  findViewById(R.id.material);
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
            Button team_work= (Button) findViewById(R.id.team_work);
            team_work.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AttendenceActivity();
                }
            });
//            Button teamwork= (Button) findViewById(R.id.team_work);
             scanqr= (Button) findViewById(R.id.scan_qr);
            scan_qr_text =findViewById(R.id.scan_qr_text) ;
            scanqr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scanqrActivity();
                }
            });
            mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();
            if (user != null) {
                FirebaseDatabase
                        .getInstance()
                        .getReference("users")
                        .child(user.getUid())
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                recievedUser = dataSnapshot.getValue(User.class);
                                if(recievedUser!=null){
                                    if (recievedUser.getType().equals("Doctor")) {
                                        scanqr.setVisibility(View.GONE);
                                        scan_qr_text.setVisibility(View.GONE);
                                    }else
                                    {   scanqr.setVisibility(View.VISIBLE);
                                    scan_qr_text.setVisibility(View.GONE);
                                }}
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

        }
        }
        public void materialActivity(){
            if(course.getName().equals("Data Communication")){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1Y62BZihwgnrMor_i4je47s-VZWYJaRBO?usp=sharing"));
                startActivity(browserIntent);
            }
             else if(course.getName().equals("Image Processing")){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1D7Me8E4W5qFVwtkSPsE-m1JRwxQG-z42?usp=sharing"));
                startActivity(browserIntent);
            }
            else if(course.getName().equals("Dynamic Language")){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1K8L1Tjassjkf_04KyBuYprZ8bVADyXNb?usp=sharing"));
                startActivity(browserIntent);
            }
           else if(course.getName().equals("Operating System")){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1-RlTIfbfjDQZ1K8CRMFVULhSgWO_N55c?usp=sharing"));
                startActivity(browserIntent);
            }
            else if(course.getName().equals("Data Minning")){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1EUQk4ZZax0Ty7AvRkosvs4Cit-jD84GO?usp=sharing"));
                startActivity(browserIntent);
            }
            else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/1EUQk4ZZax0Ty7AvRkosvs4Cit-jD84GO?usp=sharing"));
                startActivity(browserIntent);
            }
        }

    public void gradeActivity(){
        Intent intent=new Intent(this,Grade.class);
        startActivity(intent);
    }
    public void AttendenceActivity(){
        Intent intent=new Intent(this,Attendence.class);
        startActivity(intent);
    }
       public void scanqrActivity(){
        Intent intent=new Intent(this,QRActivity.class);
        startActivity(intent);
    }
    }

