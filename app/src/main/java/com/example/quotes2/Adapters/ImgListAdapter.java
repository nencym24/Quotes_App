package com.example.quotes2.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quotes2.Clicks.ImgClick;
import com.example.quotes2.R;

import java.util.ArrayList;

public class ImgListAdapter extends RecyclerView.Adapter<ImgListAdapter.ImgListHolder> {


    ArrayList<Integer> imgArray;
    ImgClick click;
    Context context;

    public ImgListAdapter(ArrayList<Integer> imgArray, ImgClick click) {
        this.imgArray = imgArray;
        this.click = click;
    }
    @NonNull
    @Override
    public ImgListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_item,parent,false);
        return new ImgListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgListHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(imgArray.get(position)).into(holder.imgItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {click.getImg(position);}
        });

    }

    @Override
    public int getItemCount() {
        return imgArray.size();
    }

    public  class ImgListHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        public ImgListHolder(@NonNull View itemView) {
            super(itemView);

            imgItem = itemView.findViewById(R.id.imgItem);
        }
    }
}
