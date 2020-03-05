package test22_net.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BSserverThreadTCP {
    public static void main(String[] args) {
        System.out.println("服务器启动完成，等待连接");
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    BufferedReader br = null;
                    FileInputStream fis = null;
                    try {
                        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        //     GET /web/index.html HTTP/1.1
                        String[] s = br.readLine().split(" ");
                        //      /web/index.html
                        String path = s[1];

                        fis = new FileInputStream("test01_javase" + path);
                        OutputStream os = socket.getOutputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        // 写入HTTP协议响应头,固定写法
                        os.write("HTTP/1.1 200 OK\n\r".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        // 必须要写入空行,否则浏览器不解析
                        os.write("\r\n".getBytes());

                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (br != null) br.close();
                            if (fis != null) fis.close();
//                            if (socket != null) socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
