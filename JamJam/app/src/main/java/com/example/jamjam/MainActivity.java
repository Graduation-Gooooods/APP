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
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //음성인식
    Intent i;
    SpeechRecognizer mRecognizer;
    ImageButton btnSttStart;
    Context cThis;
    EditText txtInMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cThis=this; //음성인식 contents
        //음성인식
        i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getApplicationContext().getPackageName());
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
        mRecognizer = SpeechRecognizer.createSpeechRecognizer(cThis);

        mRecognizer.setRecognitionListener(listener);
        btnSttStart= (ImageButton) findViewById(R.id.btn_stt_start);
        //음성인식 버튼
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
            //Toast.makeText(getApplicationContext(), "지금부터 말을 해주세요!", Toast.LENGTH_SHORT).show();//말하기 시작했을 때 호출
        }
        @Override
        public void onRmsChanged(float rmsdB) {
            //Toast.makeText(getApplicationContext(), "onRmsChanged..", Toast.LENGTH_SHORT).show();//입력받는 소리 크기
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onBufferReceived(byte[] buffer) {
            //System.out.println("onBufferReceived.........................");
            //Toast.makeText(getApplicationContext(), "onBufferReceived..", Toast.LENGTH_SHORT).show();//말을 시작하고 인식 된 단어를 버퍼에 담기
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
            String key="";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = results.getStringArrayList(key);
            String[] rs = new String[mResult.size()];
            mResult.toArray(rs);
            txtInMsg.setText(rs[0]+"\r\n"+txtInMsg.getText());
            FuncVoiceOrderCheck(rs[0]);
            //mRecognizer.startListening(i); //음성인식이 계속 되는 구문
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
            if(r.length()<1)return;
            r.replace(" ","");//공백제거
        }
    };
    protected void onDestroy() {
        super.onDestroy();
        if(mRecognizer!=null){
            mRecognizer.destroy();
            mRecognizer.cancel();
            mRecognizer=null;
        }
    }

    //OnButtonClick

    public void Passitive_btnClicked (View v){
        Intent intent1 = new Intent(getApplicationContext(), sudongmenu.class);
        startActivity(intent1);
    }

    public void Auto_btnClicked (View view){
        Intent intent5 = new Intent(getApplicationContext(), Automenu.class);
        startActivity(intent5);
    }

    public void Train_btnClicked (View view){
        Intent intent3 = new Intent(getApplicationContext(), Trainmenu.class);
        startActivity(intent3);
    }

    public void Newhand(View view) {
        Intent intent4 = new Intent(getApplicationContext(), Firstpage.class);
        startActivity(intent4);

    }

    public void graphclick(View view) {
        Intent intent2 = new Intent(this, recycler_main.class);
        startActivity(intent2);
    }

    public void start_stop_onClick(View view) {
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent1);
    }

}
