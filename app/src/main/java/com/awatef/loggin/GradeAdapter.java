package com.awatef.loggin;

/**
 * Created by awatef on 6/30/2019.
 */

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter <GradesHolder>
{

    List<GradeTable> grades = Collections.emptyList();
    Context context;

    public GradeAdapter(List<GradeTable> grades, Context context) {

        this.grades = grades;
        this.context = context;
    }

    @NonNull
    @Override
    public GradesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context=viewGroup.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.grades_row,viewGroup,false);

        GradesHolder holder = new GradesHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GradesHolder viewHolder, int i) {
        GradeTable name = grades.get(i);
        viewHolder.names.setText(name.getName());
        viewHolder.quiz1.setText(String.valueOf(name.getQuiz1()));
        viewHolder.quiz2.setText(String.valueOf(name.getQuiz2()));
        viewHolder.mid.setText(String.valueOf(name.getMid()));

    }

    @Override
    public int getItemCount() {
        return grades.size();
    }

}
