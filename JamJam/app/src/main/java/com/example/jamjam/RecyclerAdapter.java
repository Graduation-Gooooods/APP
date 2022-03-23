package com.example.jamjam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    private final ArrayList<Data> listData = new ArrayList<>();

    @NonNull
    @Override

    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {

        holder.OnBind(listData.get(position));
    }

    @Override
    public int getItemCount() {

        return listData.size();
    }
    void addItem(Data data){

        listData.add(data);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView1;
        private final TextView textView2;

        ItemViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);

        }
        void OnBind(Data data) {
            textView1.setText(data.getTitle());
            textView2.setText(data.getContent());

        }

    }
}
