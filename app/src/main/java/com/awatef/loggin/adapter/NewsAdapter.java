package com.awatef.loggin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.awatef.loggin.R;
import com.awatef.loggin.model.Course;
import com.awatef.loggin.model.New;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<New> news;
    private Context context;

    public NewsAdapter(Context context, ArrayList<New> news) {
        this.news = news;
        this.context = context;

    }

    public void addNews(New recivedNew) {
        news.add(recivedNew);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_new, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.new1 = news.get(position);

        holder.newNameTV.setText(holder.new1.getDescription());
        Glide.with(context).load(holder.new1.getImageUrl()).into(holder.newImageIV);

    }



    @Override
    public int getItemCount() {
        return news.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView newNameTV;
        ImageView newImageIV;

        New new1;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            newNameTV = view.findViewById(R.id.newNameTV);
            newImageIV = view.findViewById(R.id.newImageIV);

        }
    }

}