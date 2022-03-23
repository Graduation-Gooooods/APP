package com.example.jamjam;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;


public class recycler_main extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_main);

        init();

        getData();

    }
    private void init(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }


    @SuppressLint("NotifyDataSetChanged")
    private void getData() {

        List<String> listTitle = Arrays.asList("1","2","3","4","5","6","7","7","8","9","10","11","12","13","14","15","16");
        List<String> listContent = Arrays.asList(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16"
        );


        for(int i = 0; i<listTitle.size(); i++){

            Data data=new Data();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));

            adapter.addItem(data);

        }

        adapter.notifyDataSetChanged();
    }


}
