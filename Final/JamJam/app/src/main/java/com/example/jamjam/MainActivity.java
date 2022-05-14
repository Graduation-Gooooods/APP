package com.example.jamjam;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    static RequestQueue requestQueue;

    //음성인식
    Intent i;
    SpeechRecognizer mRecognizer;
    ImageButton btnSttStart;
    Context cThis;
    //recyclerview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);



        cThis = this; //음성인식 contents
        //음성인식
        i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getApplicationContext().getPackageName());
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
        mRecognizer = SpeechRecognizer.createSpeechRecognizer(cThis);

        mRecognizer.setRecognitionListener(listener);
        btnSttStart = (ImageButton) findViewById(R.id.btn_stt_start);
        //음성인식 버튼
        btnSttStart.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "음성인식시작", Toast.LENGTH_SHORT).show();
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
                //권한을 허용하지 않는 경우
            } else {
                //권한을 허용한 경우
                try {
                    mRecognizer.startListening(i);
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        });


        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

    private final RecognitionListener listener = new RecognitionListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getApplicationContext(), "지금부터 말을 해주세요!", Toast.LENGTH_SHORT).show();
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBeginningOfSpeech() {

        }

        @Override
        public void onRmsChanged(float rmsdB) {
            //입력받는 소리 크기
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBufferReceived(byte[] buffer) {
          //말을 시작하고 인식 된 단어를 버퍼에 담기
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onEndOfSpeech() {
            Toast.makeText(getApplicationContext(), "onEndOfSpeech..", Toast.LENGTH_SHORT).show();//말하기 중지 시 호출
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onError(int error) {
            Toast.makeText(getApplicationContext(), "천천히 다시 말해주세요.", Toast.LENGTH_SHORT).show();
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onResults(Bundle results) {
            Log.d("jamjam", "onResults");

            String key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = results.getStringArrayList(key);
            String[] rs = new String[mResult.size()];
            mResult.toArray(rs);
            FuncVoiceOrderCheck(rs[0]);
            //mRecognizer.startListening(i); //음성인식이 계속 되는 구문

            Log.d("jamjam", "text:" + rs[0]);
            Toast.makeText(getApplicationContext(), rs[0], Toast.LENGTH_SHORT).show();//말하기 중지 시 호출
            makeRequest(rs[0]);
        }

        @Override
        public void onPartialResults(Bundle partialResults) {
            //System.out.println("onPartialResults..");
            Toast.makeText(getApplicationContext(), "onPartialResults..", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onEvent(int eventType, Bundle params) {
            Toast.makeText(getApplicationContext(), "onEvent..", Toast.LENGTH_SHORT).show();
        }


        private void FuncVoiceOrderCheck(String r) {
            if (r.length() < 1) return;
            r.replace("", "");//공백제거
        }
    };

    protected void onDestroy() {
        super.onDestroy();
        if (mRecognizer != null) {
            mRecognizer.destroy();
            mRecognizer.cancel();
            mRecognizer = null;
        }
    }

    //OnButtonClick

    public void Passitive_btnClicked(View v) {
        Intent intent1 = new Intent(getApplicationContext(), sudongmenu.class);
        startActivity(intent1);
    }

    public void Auto_btnClicked(View view) {
        Intent intent5 = new Intent(getApplicationContext(), Automenu.class);
        startActivity(intent5);
    }

    public void Train_btnClicked(View view) {
        Intent intent3 = new Intent(getApplicationContext(), Trainmenu.class);
        startActivity(intent3);
    }

    //modechange
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked)
                    // Pirates are the best
                makeRequestMC_auto();
                break;
            case R.id.radioButton2:
                if (checked)
                    makeRequestMC_manual();
                    break;
            case R.id.radioButton3:
                if (checked)
                    makeRequestMC_train();
                    break;
        }
    }
    //modechange_request
    private void makeRequestMC_auto() {
        try {
            String url = "http://114.71.220.74:2018/chmode/"+ URLEncoder.encode("auto", "UTF-8") ;
            Log.d("value: ", "auto");
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
    private void makeRequestMC_manual() {
        try {
            String url = "http://114.71.220.74:2018/chmode/"+ URLEncoder.encode("manual", "UTF-8") ;
            Log.d("value: ", "manual");
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
    private void makeRequestMC_train() {
        try {
            String url = "http://114.71.220.74:2018/chmode/"+ URLEncoder.encode("train", "UTF-8") ;
            Log.d("value: ", "train");
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



//voice
    private void makeRequest(String text) {

        try {
            String url = "http://114.71.220.74:2018/voice/" + URLEncoder.encode(text, "UTF-8");

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
            Toast.makeText(this, "오류", Toast.LENGTH_SHORT).show();
        }

    }



}


