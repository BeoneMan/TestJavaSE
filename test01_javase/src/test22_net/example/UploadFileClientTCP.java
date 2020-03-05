package test22_net.example;

import java.io.*;
import java.net.Socket;

public class UploadFileClientTCP {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            OutputStream socketOs = socket.getOutputStream();
            File file = new File("C:\\Users\\Administrator\\Desktop\\abc.jpg");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes)) != -1) {
                socketOs.write(bytes, 0, len);
            }
            socket.shutdownOutput();

            //接收客户端回收数据
            InputStream socketIs = socket.getInputStream();
            while ((len = socketIs.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, len));
            }
            socket.shutdownInput();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
