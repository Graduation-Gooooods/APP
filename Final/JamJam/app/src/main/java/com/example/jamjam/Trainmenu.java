package com.example.jamjam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;

public class Trainmenu extends AppCompatActivity {
    static RequestQueue requestQueue;
    private EditText scc;
    private EditText req;
    private EditText ex_time;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainmenu);

       // scc = findViewById(R.id.scc);
       // req = findViewById(R.id.req);
       // ex_time = findViewById(R.id.ex_time);
    }
      /*  public void startonClick(View view) {
            if (requestQueue == null) {
                requestQueue = Volley.newRequestQueue(getApplicationContext());
            }
        makeRequest();
        }

    private void makeRequest() {
        try {
            String url = "http://114.71.220.74:2018/get/training " + URLEncoder.encode("1", "UTF-8");

            //JsonStreamParser
            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    url,
                    response -> {
                        Log.d("GSON", "응답 -> " + response);
                        processResponse(response);
                        // 성공 / 실패

                    },
                    error -> Log.d("GSON", "에러 -> " + error.getMessage())
            ) {
                @Override
                protected Map<String, String> getParams() {

                    return new HashMap<>();
                }
            };
            request.setShouldCache(false);
            requestQueue.add(request);
            Log.d("GSON","요청보냄");
        } catch (Exception e) {
            Toast.makeText(this, "오류", Toast.LENGTH_SHORT).show();
        }
        Log.d("request","success");
    }

    private void processResponse(String response) {
        Log.d("jamjam", "response:" + response);
        Gson gson = new Gson();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();

        DataInfo dataInfo = gson.fromJson(response, DataInfo.class);
        try {
            JSONObject Jobject = dataInfo.getJSONObjecct();
            String scc = Jobject.getString("scc");
            String req = Jobject.getString("req");
            String ex_time = Jobject.getString("ex_time");

            sb1.append(scc);
            sb2.append(req);
            sb3.append(ex_time);

            Log.d("성공","scc"+sb1.append(scc));
            Log.d("성공","req"+sb2.append(req));
            Log.d("성공","time"+sb3.append(ex_time));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    */

        public void TR_click (View view){
            Intent intent2 = new Intent(this, recycler_train_main.class);
            startActivity(intent2);
        }
    }