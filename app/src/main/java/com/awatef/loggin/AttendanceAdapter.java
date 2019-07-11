package com.awatef.loggin;

/**
 * Created by awatef on 6/30/2019.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceHolder> {

    List<AttendanceTable> attendance;
    public AttendanceAdapter (List<AttendanceTable> attendance){
        this.attendance=attendance;
    }



    @NonNull
    @Override
    public AttendanceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.attendence_row,viewGroup,false);
        AttendanceHolder holder=new AttendanceHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceHolder viewHolder, int i) {

        AttendanceTable name = attendance.get(i);
        viewHolder.name.setText(name.name);
        viewHolder.box1.setChecked(name.getB1());
        viewHolder.box2.setChecked(name.getB2());
        viewHolder.box3.setChecked(name.getB3());


    }

    @Override
    public int getItemCount() {
        return attendance.size();
    }
    class AttendanceHolder extends RecyclerView.ViewHolder {

        TextView name;
        CheckBox box1;
        CheckBox box2;
        CheckBox box3;
        public AttendanceHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.names);
            box1 = (CheckBox) itemView.findViewById(R.id.b1);
            box2 = (CheckBox) itemView.findViewById(R.id.b2);
            box3 = (CheckBox) itemView.findViewById(R.id.b3);

        }
    }
}