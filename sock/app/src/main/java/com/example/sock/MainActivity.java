package com.example.sock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button connect_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect_btn = findViewById(R.id.Btn);
        connect_btn.setOnClickListener(v -> {
            ClientThread thread = new ClientThread();
            thread.start();
        });
    }

    static class ClientThread extends Thread {
        public void run() {

            String host = "114.71.220.163";
            int port = 3333;
            //String MESSAGE_TO_SERVER = ;

            try {
                // 소켓통신 시작
                Socket socket = new Socket(host, port);
                Log.d("[연결확인]", "연결됨");
                byte[] bytes = null;
                String msg = null;

                //Client에서 Server로 보내기 위한 통로
                OutputStream os = socket.getOutputStream();
                msg = "Hi, Server";
                bytes=msg.getBytes();
                //os.write(msg.getBytes());
                os.write(bytes);
                msg = new String(bytes, 0, bytes.length, "UTF-8");
                System.out.println("데이터보내기성공 : " + msg);
                os.flush();

                //서버에서 클라이언트로 받기 위한 통로

                InputStream is = socket.getInputStream();

                String r_msg = null;
                bytes = new byte[1024];
                int readByteCount = is.read(bytes);
                r_msg = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("데이터받기성공 : " + r_msg);


                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}