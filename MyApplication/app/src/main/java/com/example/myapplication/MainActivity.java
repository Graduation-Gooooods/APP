package com.example.myapplication;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;


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
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            String host = "114.71.220.163";
            int port = 3333;

            try {
                Socket socket = new Socket(host, port);
                Log.d("[연결확인]","연결됨");

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject(URLEncoder.encode("Hello", "utf-16"));
                Log.d("내용 : ", String.valueOf(outstream));
                outstream.flush();
                Log.d("Client_send", "Sent to server.");

                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                byte[]data = (byte[]) ois.readObject();
                //String remake = new String(data,"utf-16");
                //inputStream.read(data);

                //URLDecoder.decode(String.valueOf(data),"utf-16");


               // data = URLDecoder.decode(inputStream,"utf-16");
                //inputStream.read(data);
                Log.d("Client_recv", "Received data : "+ data.length);
                /*ObjectInputStream InputStream = new ObjectInputStream(socket.getInputStream());
                InputStream input = socket.getInputStream();
                byte[] data = new byte[1024];
                int data = InputStream.read();

                input.read(data);
                InputStream.readObject(URLDecoder.decode(String.valueOf(data), "utf-16"));
                Log.d("Client_recv", "Received data: " + data);*/
                ois.close();
                is.close();
                socket.close();

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