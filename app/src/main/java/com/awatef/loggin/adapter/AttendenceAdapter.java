package com.awatef.loggin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.awatef.loggin.R;
import com.awatef.loggin.model.User;

import java.util.ArrayList;
import java.util.Random;

public class AttendenceAdapter extends RecyclerView.Adapter<AttendenceAdapter.ViewHolder> {

    private ArrayList<User> users;
    private Context context;

    public AttendenceAdapter(Context context, ArrayList<User> users) {
        this.users = users;
        this.context = context;

    }

    public void addUsers(User addedusers) {
        users.add(addedusers);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_attendence, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.user = users.get(position);
        holder.attendenceNameTV.setText(holder.user.getName());
        holder.attendenceTV.setText(String.valueOf(holder.user.getAttendence())+ "  times");
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView attendenceNameTV;
        TextView attendenceTV;
        User user;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            attendenceTV = view.findViewById(R.id.attendenceTV);
            attendenceNameTV = view.findViewById(R.id.attendenceNameTV);

        }
    }
}