package com.example.jamjam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Data> dataList;

    public RecyclerAdapter(Context context, ArrayList<Data> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      //  holder.Modetype.setText(dataList.get(position).getMode());
        holder.modescc.setText(dataList.get(position).getScc());
        holder.modetm.setText(dataList.get(position).getEx_time());
        holder.modecs.setText(dataList.get(position).getNow_step());

        // 날자
        String date = dataList.get(position).getDate_time();
        if (date.length() > 10) {
            date = date.substring(0, 10);
        }
        holder.date_time.setText(date);
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       // protected TextView Modetype;
        protected TextView modescc;
        protected TextView modetm;
        protected TextView modecs;
        protected TextView date_time;

        public ViewHolder(View itemView) {
            super(itemView);
           // this.Modetype = itemView.findViewById(R.id.Modetype);
            this.modescc = itemView.findViewById(R.id.modescc);
            this.modetm = itemView.findViewById(R.id.modetm);
            this.modecs = itemView.findViewById(R.id.modecs);
            this.date_time = itemView.findViewById(R.id.date_time);
        }
    }
}




