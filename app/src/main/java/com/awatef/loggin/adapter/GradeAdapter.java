package com.awatef.loggin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.awatef.loggin.R;
import com.awatef.loggin.model.New;
import com.awatef.loggin.model.User;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.ViewHolder> {

    private ArrayList<User> users;
    private Context context;

    public GradeAdapter(Context context, ArrayList<User> users) {
        this.users = users;
        this.context = context;

    }

    public void addUsers(User addedusers) {
        users.add(addedusers);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.grades_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.user = users.get(position);
        holder.names.setText(holder.user.getName());
        final int min = 0;
        final int max = 10;
        final int random = new Random().nextInt((max - min) + 1) + min;
        final int randomQ2 = new Random().nextInt((max - min) + 1) + min;
        holder.q1.setText(String.valueOf(random));
        holder.q2.setText(String.valueOf(randomQ2));

    }



    @Override
    public int getItemCount() {
        return users.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView names;
        TextView q1;
        TextView q2;
        TextView mid;

        User user;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            names = view.findViewById(R.id.names);
            q1 = view.findViewById(R.id.q1);
            q2 = view.findViewById(R.id.q2);
            mid = view.findViewById(R.id.mid);

        }
    }

}