package com.example.jamjam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


public class recycler_main extends AppCompatActivity {
    RecyclerAdapter adapter;
    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);




        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        makeRequest();
        Log.d("request","request");
    }
        public void makeRequest(){
            String url = "http://114.71.220.163:7102/app/getdata";
            StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
                Log.d("GSON", "응답-> " + response);

                processResponse(response);
            }, error -> Log.d("GSON", "에러-> " + error.getMessage())) {
                protected Map<String, String> getParams() {
                    return new HashMap<>();
                }
            };
            request.setShouldCache(false);
            requestQueue.add(request);
            Log.d("GSON", "요청보냄");
        }

        @SuppressLint("NotifyDataSetChanged")
        public void processResponse(String response){
        Gson gson = new Gson();
            recordList RecordList;
            RecordList = gson.fromJson(response, recordList.class);
            Log.d("결과", "요청보냄"+RecordList.recordresult.recordlist.size());

            adapter.addItem(RecordList.recordresult.recordlist);
            adapter.notifyDataSetChanged();

}


}
