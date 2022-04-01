package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity {
    Button connect_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect_btn = findViewById(R.id.Btn);
        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientThread thread = new ClientThread();
                thread.start();
            }
        });
    }

    class ClientThread extends Thread {
        @Override
        public void run() {
            String host = "114.71.220.163";
            int port = 3333;

            try {
                Socket socket = new Socket(host, port);
                Log.d("[연결확인]","연결됨");



                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject(URLEncoder.encode("Hello", "utf-16"));
                outstream.flush();
                Log.d("ClientStream", "Sent to server.");

//                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
//                Object input = instream.readObject();

                InputStream input = socket.getInputStream();
                byte[] data = new byte[1024];
                input.read(data);
                Log.d("ClientThread", "Received data: " + data);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}/*
                byte[] bytes;
                String message;

                OutputStream os = socket.getOutputStream();
                message = "hello";
                bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("[보내기성공]");

                InputStream is = socket.getInputStream();
                bytes = new byte[1000];
                int readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("[받기성공]" + message);

                os.write(bytes);
                is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("[2받기성공]"+ message);
                os.close();
                is.close();

                //예외처리
            } catch (Exception e) {
            }
            if (!socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException e1) {
                }
            }
        }
    }

*/