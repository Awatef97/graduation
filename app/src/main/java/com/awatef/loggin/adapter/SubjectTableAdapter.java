package com.awatef.loggin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.awatef.loggin.R;
import com.awatef.loggin.model.Course;
import com.awatef.loggin.model.SubjectTable;

import java.util.ArrayList;

public class SubjectTableAdapter extends RecyclerView.Adapter<SubjectTableAdapter.ViewHolder> {
    private ArrayList<SubjectTable> subjectTables;

    private Context context;
    private OnsubjectTableNameTVClickListener onSubjectTableActionListener;


    public SubjectTableAdapter(Context context, ArrayList<SubjectTable> subjectTables ,OnsubjectTableNameTVClickListener onSubjectTableActionListener ) {
        this.subjectTables = subjectTables;
        this.context = context;
    this.onSubjectTableActionListener = onSubjectTableActionListener ;
    }


     @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_subjecttable, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.subject = subjectTables.get(position);

        holder.subjectTableNameTV.setText(holder.subject.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onBookActionListener.onBookClick(holder.book);
           onSubjectTableActionListener.onsubjectTableNameTVClick(holder.subject);
            }
        });

    }


    @Override
    public int getItemCount() {
        return subjectTables.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView subjectTableNameTV;
        SubjectTable subject;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            subjectTableNameTV = view.findViewById(R.id.subjectTableNameTV);

        }
    }
    public interface OnsubjectTableNameTVClickListener{
        void onsubjectTableNameTVClick(SubjectTable subjectTable);
    }
}