package test22_net.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class UploadFileServerTCP {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    BufferedInputStream bis = null;
                    BufferedOutputStream bos = null;

                    try {

                        bis = new BufferedInputStream(socket.getInputStream());
                        bos = new BufferedOutputStream(new FileOutputStream(System.currentTimeMillis() + ".jpg"));
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        //读取客户端传来的文件，保存到服务器
                        while ((len = bis.read(bytes)) != -1) {
                            bos.write(bytes, 0, len);
                        }
                        socket.shutdownInput();

                        //回应客户端已经接收数据
                        OutputStream socketOs = socket.getOutputStream();
                        socketOs.write("successful".getBytes());
                        socket.shutdownOutput();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (bos != null) bos.close();
                            if (bis != null) bis.close();
                            if (socket != null) socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

