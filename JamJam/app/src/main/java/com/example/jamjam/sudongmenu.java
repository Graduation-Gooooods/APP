package com.example.jamjam;


import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class sudongmenu extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudongmenu);

        textView = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

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

                textView.setText(format("%d 번째 손가락입니다.", seekBar.getProgress()));
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

            @SuppressLint("DefaultLocale")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {
                textView2.setText(format("%d단계 입니다.", seekBar2.getProgress()));

            }


        });


    }

    public void graphclick(View view) {
        Intent intent2 = new Intent(this, recycler_main.class);
        startActivity(intent2);
    }

}