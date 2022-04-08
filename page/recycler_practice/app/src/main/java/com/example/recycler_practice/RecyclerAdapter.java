package com.example.recycler_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {
    private ArrayList<Data> listData = new ArrayList<>();

    @NonNull
    @Override

    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //LayoutInflater를 이용해 전 단계에서 만들었던 item.xml을 .inflate시킴
        //return인자는 ViewHolder입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {
        //Item을 각각 보여주는(bind되는)함수
        holder.OnBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        //RecyclerView의 총 개수
        return listData.size();
    }
    void addItem(Data data){
        //외부에서 Item을 추가시킬 함수
        listData.add(data);
    }
    //RecyclerVeiw의 핵심 RecyclerView.ViewHolder
    //여기서 subView를 setting
    class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView textView1;
        private TextView textView2;
        private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
        void OnBind(Data data) {
            textView1.setText(data.getTitle());
            textView2.setText(data.getContent());
            imageView.setImageResource(data.getResld());
        }

    }
}
