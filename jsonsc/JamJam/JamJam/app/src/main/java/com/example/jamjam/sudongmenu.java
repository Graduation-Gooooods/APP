package com.example.jamjam;


import static java.lang.String.format;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

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


        try{
            String host = "114.71.220.163";
            int port = 3333;
            Socket socket = new Socket(host, port);
            Log.d("[연결확인]", "연결됨");



        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged (SeekBar seekBar1,int progress, boolean fromUser){
            }
                @Override
                public void onStartTrackingTouch (SeekBar seekBar1){
            }
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @SuppressLint("DefaultLocale")
                @Override
                public void onStopTrackingTouch (SeekBar seekBar1){
                textView1.setText(format("엄지손가락 %d단계 입니다.", seekBar1.getProgress()));
                    try{
                        byte[] bytes;
                        OutputStream os = socket.getOutputStream();
                        String msg = String.valueOf(seekBar1.getProgress());
                        bytes=msg.getBytes();
                        os.write(bytes);msg = new String(bytes, 0, bytes.length, StandardCharsets.UTF_8);
                        System.out.println("데이터보내기성공 : " + msg);
                        os.flush();

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            });

            SeekBar seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged (SeekBar seekBar2,int progress, boolean fromUser){
            }
                @Override
                public void onStartTrackingTouch (SeekBar seekBar2){
            }
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @SuppressLint("DefaultLocale")
                @Override
                public void onStopTrackingTouch (SeekBar seekBar2){
                textView2.setText(format("검지손가락 %d단계 입니다.", seekBar2.getProgress()));
                    try{
                        byte[] bytes;
                        OutputStream os = socket.getOutputStream();
                        String msg = String.valueOf(seekBar2.getProgress());
                        bytes=msg.getBytes();
                        os.write(bytes);msg = new String(bytes, 0, bytes.length, StandardCharsets.UTF_8);
                        System.out.println("데이터보내기성공 : " + msg);
                        os.flush();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            SeekBar seekBar3 = findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged (SeekBar seekBar3,int progress, boolean fromUser){
            }
                @Override
                public void onStartTrackingTouch (SeekBar seekBar3){
            }
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @SuppressLint("DefaultLocale")
                @Override
                public void onStopTrackingTouch (SeekBar seekBar3){
                textView3.setText(format("중지손가락 %d단계 입니다.", seekBar3.getProgress()));
                    try{
                        byte[] bytes;
                        OutputStream os = socket.getOutputStream();
                        String msg = String.valueOf(seekBar3.getProgress());
                        bytes=msg.getBytes();
                        os.write(bytes);msg = new String(bytes, 0, bytes.length, StandardCharsets.UTF_8);
                        System.out.println("데이터보내기성공 : " + msg);
                        os.flush();

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            SeekBar seekBar4 = findViewById(R.id.seekBar4);
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged (SeekBar seekBar4,int progress, boolean fromUser){
            }
                @Override
                public void onStartTrackingTouch (SeekBar seekBar4){
            }
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @SuppressLint("DefaultLocale")
                @Override
                public void onStopTrackingTouch (SeekBar seekBar4) {
                    textView4.setText(format("약지손가락 %d단계 입니다.", seekBar4.getProgress()));
                    try {
                        byte[] bytes;
                        OutputStream os = socket.getOutputStream();
                        String msg = String.valueOf(seekBar4.getProgress());
                        bytes = msg.getBytes();
                        os.write(bytes);
                        msg = new String(bytes, 0, bytes.length, StandardCharsets.UTF_8);
                        System.out.println("데이터보내기성공 : " + msg);
                        os.flush();

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            SeekBar seekBar5 = findViewById(R.id.seekBar5);
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged (SeekBar seekBar5,int progress, boolean fromUser){
            }
                @Override
                public void onStartTrackingTouch (SeekBar seekBar5){
            }
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @SuppressLint("DefaultLocale")
                @Override
                public void onStopTrackingTouch (SeekBar seekBar5) {
                    textView5.setText(format("새끼손가락 %d단계 입니다.", seekBar5.getProgress()));
                    try {
                        byte[] bytes;
                        OutputStream os = socket.getOutputStream();
                        String msg = String.valueOf(seekBar5.getProgress());
                        bytes = msg.getBytes();
                        os.write(bytes);
                        msg = new String(bytes, 0, bytes.length, StandardCharsets.UTF_8);
                        System.out.println("데이터보내기성공 : " + msg);
                        os.flush();

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            socket.close();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void graphclick(View view) {
        Intent intent2 = new Intent(this, recycler_main.class);
        startActivity(intent2);
    }

}
