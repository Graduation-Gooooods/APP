package com.example.jamjam;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        //라디오그룹설정
        RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(radioGroupbuttonchangeListener);
    }
    //라디오그룹클릭리스너

    final RadioGroup.OnCheckedChangeListener radioGroupbuttonchangeListener = (radioGroup1, i) -> {
        if (i == R.id.radioButton) {
            Toast.makeText(Firstpage.this, "선택되었습니다", Toast.LENGTH_LONG).show();
        }


    };


/*
    public void onBackButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), "돌아가기", Toast.LENGTH_LONG).show();
        finish();
    }
    */


    public void firstpagenext(View v) {
        Intent intent = new Intent(getApplicationContext(), Mainhand.class);
        startActivity(intent);
    }
}
