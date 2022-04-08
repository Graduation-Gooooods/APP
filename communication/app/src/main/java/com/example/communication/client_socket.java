package com.example.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class client_socket {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //서버접속
            socket = new Socket("127.0.0.1", 2018);

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



            //server에 보낼 데이터 입력
            //버퍼사용->입출력효율상승
            //socket 기능 중 stream 불러와 outputstreamwriter에 저장
           /* BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //버퍼출력
            bufWriter.write("hello world");
            //버퍼개행
            bufWriter.newLine();
            //남아있는 데이터 모두 출력
            bufWriter.flush();
            //server가 보낸 데이터 출력
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufReader.readLine();
            System.out.println("Message : " + message);
            message = bufReader.readLine();

            */


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
