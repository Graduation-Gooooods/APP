package com.example.voice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Intent i;
    SpeechRecognizer mRecognizer;
    Button btnSttStart;
    Context cThis;
    EditText txtInMsg;
    EditText txtSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cThis=this;
        //음성인식
        i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getApplicationContext().getPackageName());
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
        mRecognizer = SpeechRecognizer.createSpeechRecognizer(cThis);

        mRecognizer.setRecognitionListener(listener);

        //음성인식 버튼
        btnSttStart=(Button)findViewById(R.id.btn_stt_start);
        btnSttStart.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "음성인식시작", Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO},1);
                    //권한을 허용하지 않는 경우
                } else {
                    //권한을 허용한 경우
                    try {
                        mRecognizer.startListening(i);
                    } catch(SecurityException e) {
                        e.printStackTrace();
                    }
                }
            });
        txtInMsg=(EditText)findViewById(R.id.txtInMsg);
        txtSystem=(EditText)findViewById(R.id.txtSystem);
    }
    private final RecognitionListener listener = new RecognitionListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReadyForSpeech(Bundle params) {
            //txtSystem.setText("onReadyForSpeech..........."+"\r\n"+txtSystem.getText());
            Toast.makeText(getApplicationContext(), "지금부터 말을 해주세요!", Toast.LENGTH_SHORT).show();
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onBeginningOfSpeech() {
            Toast.makeText(getApplicationContext(), "지금부터 말을 해주세요!", Toast.LENGTH_SHORT).show();
            txtSystem.setText("지금부터 말을 해주세요..........."+"\r\n"+txtSystem.getText());
        //말하기 시작했을 때 호출
        }

        @Override
        public void onRmsChanged(float rmsdB) {
            System.out.println("onRmsChanged.........................");
        //입력받는 소리 크기
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBufferReceived(byte[] buffer) {
            System.out.println("onBufferReceived.........................");
            txtSystem.setText("onBufferReceived..........."+"\r\n"+txtSystem.getText());
        //말을 시작하고 인식 된 단어를 버퍼에 담기
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onEndOfSpeech() {
            System.out.println("onEndOfSpeech.........................");
            txtSystem.setText("onEndOfSpeech..........."+"\r\n"+txtSystem.getText());
        //말하기 중지 시 호출
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onError(int error) {
            Toast.makeText(getApplicationContext(), "천천히 다시 말해주세요.", Toast.LENGTH_SHORT).show();
            txtSystem.setText("천천히 다시 말해 주세요..........."+"\r\n"+txtSystem.getText());
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onResults(Bundle results) {
            String key="";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = results.getStringArrayList(key);
            String[] rs = new String[mResult.size()];
            mResult.toArray(rs);
            txtInMsg.setText(rs[0]+"\r\n"+txtInMsg.getText());
            FuncVoiceOrderCheck(rs[0]);
            mRecognizer.startListening(i); //음성인식이 계속 되는 구문
        }

        @Override
        public void onPartialResults(Bundle partialResults) {
            System.out.println("onPartialResults.........................");
        }

        @Override
        public void onEvent(int eventType, Bundle params) {
            System.out.println("onEvent.........................");
        }



        private void FuncVoiceOrderCheck(String r) {
            if(r.length()<1)return;
            r.replace(" ","");//공백제거
        }
    };


}