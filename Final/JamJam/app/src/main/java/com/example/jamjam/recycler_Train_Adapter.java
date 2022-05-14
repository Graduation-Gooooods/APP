package com.example.jamjam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_Train_Adapter extends RecyclerView.Adapter<recycler_Train_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Data> dataList;

    public recycler_Train_Adapter(Context context, ArrayList<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.Modetype.setText(dataList.get(position).getMode());
        holder.modescc.setText(dataList.get(position).getScc());
        holder.modetm.setText(dataList.get(position).getEx_time());
        holder.modecs.setText(dataList.get(position).getNow_step());
        holder.req.setText(dataList.get(position).getReq());
        holder.set_time.setText(dataList.get(position).getSetTime());
        holder.per_time.setText(dataList.get(position).getPerTime());
        holder.msc_mean.setText(dataList.get(position).getMscMean());
        holder.tns_mean.setText(dataList.get(position).gettnsMean());


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

    public class ViewHolder extends RecyclerView.ViewHolder {
       // protected TextView Modetype;
        protected TextView modescc;
        protected TextView modetm;
        protected TextView modecs;
        protected TextView req;
        protected TextView set_time;
        protected TextView per_time;
        protected TextView msc_mean;
        protected TextView tns_mean;
        protected TextView date_time;

        public ViewHolder(View itemView) {
            super(itemView);
           // this.Modetype = itemView.findViewById(R.id.Modetype);
            this.modescc = itemView.findViewById(R.id.modescc);
            this.modetm = itemView.findViewById(R.id.modetm);
            this.modecs = itemView.findViewById(R.id.modecs);
            this.req = itemView.findViewById(R.id.req);
            this.set_time = itemView.findViewById(R.id.set_time);
            this.per_time = itemView.findViewById(R.id.per_time);
            this.msc_mean = itemView.findViewById(R.id.msc_mean);
            this.tns_mean = itemView.findViewById(R.id.tns_mean);
            this.date_time = itemView.findViewById(R.id.date_time);
        }
    }
}