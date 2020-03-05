package test22_net.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟网站服务器，使用浏览器访问自己编写的服务端程序，查看网页效果。
 */
public class BSDemo {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            socket = serverSocket.accept();
            InputStream socketIs = socket.getInputStream();

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = socketIs.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
