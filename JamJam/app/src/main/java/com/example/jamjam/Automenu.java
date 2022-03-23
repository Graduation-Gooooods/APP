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
    final String[] level = {"0단계", "1단계", "2단계", "3단계", "4단계", "5단계", "6단계", "7단계"};
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

                textView.setText(format("선택 값은 %d 입니다.", seekBar.getProgress()));
            }

        });


        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,level );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }


    public void onBackButtonClicked(View view) {
        Toast.makeText(getApplicationContext(), "돌아가기", Toast.LENGTH_LONG).show();
        finish();
    }
}
