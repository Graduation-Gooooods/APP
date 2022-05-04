package com.example.jamjam;


import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class sudongmenu extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    Button submit_1;
    Button submit_2;
    Button submit_3;
    Button submit_4;
    Button submit_5;
    static RequestQueue requestQueue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudongmenu);


        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        submit_1 = findViewById(R.id.submit_1);
        submit_2 = findViewById(R.id.submit_2);
        submit_3 = findViewById(R.id.submit_3);
        submit_4 = findViewById(R.id.submit_4);
        submit_5 = findViewById(R.id.submit_5);


        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {


            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("DefaultLocale")
            @Override

            public void onStopTrackingTouch(SeekBar seekBar1) {
                textView1.setText(format("엄지손가락 %d단계 입니다.", seekBar1.getProgress()));
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(getApplicationContext());

                }
                makeRequest1();
            }

            private void makeRequest1() {
                try {
                    String url = "http://114.71.220.163:2017/set/1/ " + URLEncoder.encode(String.valueOf(seekBar1.getProgress()), "UTF-8");
                    Log.d("value: ", "1st = " + seekBar1.getProgress());

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

        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("DefaultLocale")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {
                textView2.setText(format("검지손가락 %d단계 입니다.", seekBar2.getProgress()));
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(getApplicationContext());

                }
                makeRequest2();
            }

            private void makeRequest2() {
                try {
                    String url = "http://114.71.220.163:2017/set/2/ " + URLEncoder.encode(String.valueOf(seekBar2.getProgress()), "UTF-8");
                    Log.d("value: ", "2nd = " + seekBar2.getProgress());

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

        SeekBar seekBar3 = findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar3, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar3) {
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("DefaultLocale")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar3) {
                textView3.setText(format("중지손가락 %d단계 입니다.", seekBar3.getProgress()));

                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(getApplicationContext());

                }
                makeRequest3();
            }

            private void makeRequest3() {
                try {
                    String url = "http://114.71.220.163:2017/set/3/ " + URLEncoder.encode(String.valueOf(seekBar3.getProgress()), "UTF-8");
                    Log.d("value: ", "3rd = " + seekBar3.getProgress());

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

        SeekBar seekBar4 = findViewById(R.id.seekBar4);
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar4, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar4) {
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("DefaultLocale")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar4) {
                textView4.setText(format("약지손가락 %d단계 입니다.", seekBar4.getProgress()));
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(getApplicationContext());

                }
                makeRequest4();
            }

            private void makeRequest4() {
                try {
                    String url = "http://114.71.220.163:2017/set/4/ " + URLEncoder.encode(String.valueOf(seekBar4.getProgress()), "UTF-8");
                    Log.d("value: ", "4th = " + seekBar4.getProgress());

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

        SeekBar seekBar5 = findViewById(R.id.seekBar5);
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar5, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar5) {
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("DefaultLocale")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar5) {
                textView5.setText(format("새끼손가락 %d단계 입니다.", seekBar5.getProgress()));
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                }
                makeRequest5();
            }
            private void makeRequest5() {
                try {
                    String url = "http://114.71.220.163:2017/set/5/" + URLEncoder.encode(String.valueOf(seekBar5.getProgress()), "UTF-8");
                    Log.d("value: ", "5th = " + seekBar5.getProgress());
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

    public void SR_click(View view) {
        Intent intent2 = new Intent(this, recycler_sudong_main.class);
        startActivity(intent2);
    }
}