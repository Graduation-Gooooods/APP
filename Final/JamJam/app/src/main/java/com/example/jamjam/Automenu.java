package com.example.jamjam;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class Automenu extends AppCompatActivity {
    TextView textView;
    RequestQueue requestQueue;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automenu);


        textView = findViewById(R.id.textView); //spinner
        textView = findViewById(R.id.seekBartext); //seekbar


        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @SuppressLint("DefaultLocale")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                textView.setText(format("%d단계 입니다.", seekBar.getProgress()));

                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(getApplicationContext());

                }
                makeRequest2();
            }

            private void makeRequest2() {
                try {
                    String url = "http://114.71.220.74:2018/set/auto/" + URLEncoder.encode(String.valueOf(seekBar.getProgress()), "UTF-8");
                    Log.d("value: ", "value = " + seekBar.getProgress());

                    //JsonStreamParser
                    StringRequest request = new StringRequest(
                            Request.Method.GET,
                            url,
                            response -> {
                                Log.d("GSON", "응답 -> " + response);

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
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
    public void AR_click(View view) {
        Intent intent2 = new Intent(this, recycler_main.class);
        startActivity(intent2);
    }
}
