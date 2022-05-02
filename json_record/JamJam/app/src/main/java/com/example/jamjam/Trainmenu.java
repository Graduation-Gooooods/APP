package com.example.jamjam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Trainmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainmenu);
    }
    public void TR_click(View view) {
        Intent intent2 = new Intent(this, recycler_train_main.class);
        startActivity(intent2);
    }

    public void onBackButtonClicked(View view) {
        Toast.makeText(getApplicationContext(), "돌아가기", Toast.LENGTH_LONG).show();
        finish();
    }
}