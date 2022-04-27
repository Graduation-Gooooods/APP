package com.example.jamjam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, result1, result2, result3, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.Modetype);
            result1 = itemView.findViewById(R.id.modescc);
            result2 = itemView.findViewById(R.id.modetm);
            result3 = itemView.findViewById(R.id.modecs);
            date = itemView.findViewById(R.id.date_time);
        }


        public void addItems(Result item) {
            title.setText(item.mode);
            result1.setText(item.modescc);
            result2.setText(String.format("%s초", item.modetm));
            result3.setText(item.modecs);
            date.setText(item.date_time);
        }
    }

    ArrayList<Result> ModeResult = new ArrayList<>();

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //실제 recyclerview_item 레이아웃을 변경하는 메소드
        Result result = ModeResult.get(position);
        holder.addItems(result);

    }


    @Override
    public int getItemCount() {
        //데이터 개수
        return ModeResult != null ? ModeResult.size() : 0;
    }

    public void addItem(ArrayList<Result> items) {

        this.ModeResult = items;
    }
}


    /*
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

        public void addItems(Result result) {
        }
    }
}
*/