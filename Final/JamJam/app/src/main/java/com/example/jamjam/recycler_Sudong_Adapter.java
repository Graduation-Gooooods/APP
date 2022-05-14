package com.example.jamjam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_Sudong_Adapter extends RecyclerView.Adapter<recycler_Sudong_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Data> dataList;
    public recycler_Sudong_Adapter(Context context, ArrayList<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_sudong, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.Modetype.setText(dataList.get(position).getMode());
        holder.modescc1.setText(dataList.get(position).getScc1());
        holder.modescc2.setText(dataList.get(position).getScc2());
        holder.modescc3.setText(dataList.get(position).getScc3());
        holder.modescc4.setText(dataList.get(position).getScc4());
        holder.modescc5.setText(dataList.get(position).getScc5());
        holder.modetm.setText(dataList.get(position).getEx_time());
        holder.s1.setText(dataList.get(position).getS1());
        holder.s2.setText(dataList.get(position).getS2());
        holder.s3.setText(dataList.get(position).getS3());
        holder.s4.setText(dataList.get(position).getS4());
        holder.s5.setText(dataList.get(position).getS5());
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

    public class ViewHolder extends RecyclerView.ViewHolder {
       // protected TextView Modetype;
        protected TextView modescc1;
        protected TextView modescc2;
        protected TextView modescc3;
        protected TextView modescc4;
        protected TextView modescc5;

        protected TextView modetm;
        protected TextView s1;
        protected TextView s2;
        protected TextView s3;
        protected TextView s4;
        protected TextView s5;

        protected TextView date_time;

        public ViewHolder(View itemView) {
        super(itemView);
            //  this.Modetype = itemView.findViewById(R.id.Modetype);
        this.modescc1 = itemView.findViewById(R.id.modescc1);
        this.modescc2 = itemView.findViewById(R.id.modescc2);
        this.modescc3 = itemView.findViewById(R.id.modescc3);
        this.modescc4 = itemView.findViewById(R.id.modescc4);
        this.modescc5 = itemView.findViewById(R.id.modescc5);
        this.modetm = itemView.findViewById(R.id.modetm);
        this.s1 = itemView.findViewById(R.id.s1);
        this.s2 = itemView.findViewById(R.id.s2);
        this.s3 = itemView.findViewById(R.id.s3);
        this.s4 = itemView.findViewById(R.id.s4);
        this.s5 = itemView.findViewById(R.id.s5);
        this.date_time = itemView.findViewById(R.id.date_time);
    }
}
}