package com.awatef.loggin.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.awatef.loggin.R;
import com.awatef.loggin.model.SubjectTable;
import com.bumptech.glide.Glide;

public class TableSubjectActivity extends AppCompatActivity {
    TextView tableTV;
    ImageView tableIV ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_subject);
        Intent i = getIntent();
        SubjectTable subjectTable = (SubjectTable) i.getSerializableExtra("sampleObject");
        tableTV=findViewById(R.id.tableTV) ;
        tableIV=findViewById(R.id.tableIV) ;
        tableTV.setText(subjectTable.getName());
        Glide.with(this).load(subjectTable.getImageUrl()).into(tableIV);


    }
}
