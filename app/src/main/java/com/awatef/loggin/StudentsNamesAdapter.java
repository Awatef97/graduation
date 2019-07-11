package com.awatef.loggin;

/**
 * Created by awatef on 7/6/2019.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.awatef.loggin.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class StudentsNamesAdapter extends RecyclerView.Adapter<StudentsNamesAdapter.StudentsNamesHolder> {

    String currentLeader;
    List<StudentsNames> studentsNamesList;
    Context context;


    public  StudentsNamesAdapter(List<NamesModel> grades, Context context){
        this.studentsNamesList=studentsNamesList;
        this.context=context;
    }
    public String getCurrentLeader(){
        return currentLeader;
    }
    public void setCurrentLeader(String currentLeader){
        this.currentLeader=currentLeader;
    }

    @NonNull
    @Override
    public StudentsNamesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_row,viewGroup,false);
        StudentsNamesHolder holder=new StudentsNamesHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentsNamesHolder viewHolder, final int i) {

        StudentsNames name =studentsNamesList.get(i);
        viewHolder.studentName.setText(name.getName());
        viewHolder.addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(c,"Clicked at position"+i+viewHolder.studentName.getText(),Toast.LENGTH_SHORT).show();
                currentLeader =(String) viewHolder.studentName.getText();

                Toast.makeText(context,"the Current leader is Stored " +viewHolder.studentName.getText(),Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return studentsNamesList.size();
    }

    class StudentsNamesHolder extends RecyclerView.ViewHolder {


        TextView studentName;
        Button addbutton;

        public StudentsNamesHolder(@NonNull View itemView)  {
            super(itemView);
            studentName = (TextView) itemView.findViewById(R.id.student_name);
            addbutton = (Button) itemView.findViewById(R.id.add);



        }



    }




}
