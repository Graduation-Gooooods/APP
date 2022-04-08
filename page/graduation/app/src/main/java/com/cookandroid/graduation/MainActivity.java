package com.cookandroid.graduation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Passitive_btnClicked(View v){
        Intent intent = new Intent(getApplicationContext(),sudongpage.class);
        startActivity(intent);
    }

    }

