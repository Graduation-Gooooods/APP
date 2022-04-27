package com.example.jamjam;
import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Automenu extends AppCompatActivity {
    TextView textView;


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
            }

        });

    }
}
