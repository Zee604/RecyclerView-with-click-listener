package com.example.recyclerview;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.recyclerview.Adapter.*;

class Adapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<com.journaldev.recyclerviewcardview.Datamodel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewIcon;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public Adapter(ArrayList<com.journaldev.recyclerviewcardview.Datamodel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardslayout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        ImageView imageView = holder.imageViewIcon;
        LinearLayout ll = holder.linearLayout;

        textViewName.setText(dataSet.get(listPosition).getName());
        imageView.setImageResource(dataSet.get(listPosition).getImage());

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index= dataSet.indexOf(dataSet.get(listPosition));
                Intent i=new Intent(v.getContext(), SecondScreen.class);
//                Toast.makeText(v.getContext(), ""+index, Toast.LENGTH_SHORT).show();
                i.putExtra("indexIs", index);
                v.getContext().startActivity(i);
//                ((Activity)v.getContext()).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}