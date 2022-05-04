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
        holder.Modetype.setText(dataList.get(position).getMode());
        holder.modescc.setText(dataList.get(position).getScc());
        holder.modetm.setText(dataList.get(position).getEx_time());
        holder.modecs.setText(dataList.get(position).getNow_step());
        holder.S1.setText(dataList.get(position).getS1());
        holder.S2.setText(dataList.get(position).getS2());
        holder.S3.setText(dataList.get(position).getS3());
        holder.S4.setText(dataList.get(position).getS4());
        holder.S5.setText(dataList.get(position).getS5());
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
        protected TextView Modetype;
        protected TextView modescc;
        protected TextView modetm;
        protected TextView modecs;
        protected TextView S1;
        protected TextView S2;
        protected TextView S3;
        protected TextView S4;
        protected TextView S5;

        protected TextView date_time;

        public ViewHolder(View itemView) {
        super(itemView);
        this.Modetype = itemView.findViewById(R.id.Modetype);
        this.modescc = itemView.findViewById(R.id.modescc);
        this.modetm = itemView.findViewById(R.id.modetm);
        this.modecs = itemView.findViewById(R.id.modecs);
        this.S1 = itemView.findViewById(R.id.S1);
        this.S2 = itemView.findViewById(R.id.S2);
        this.S3 = itemView.findViewById(R.id.S3);
        this.S4 = itemView.findViewById(R.id.S4);
        this.S5 = itemView.findViewById(R.id.S5);
        this.date_time = itemView.findViewById(R.id.date_time);
    }
}
}