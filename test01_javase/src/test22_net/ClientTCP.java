package test22_net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 模拟客户端发送数据
 */
public class ClientTCP {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 1234);
            OutputStream os = socket.getOutputStream();
            os.write("已经连接了...".getBytes());
            socket.shutdownOutput();
            //接收服务端发来的数据
            InputStream is = socket.getInputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while((len=is.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
            socket.shutdownInput();

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
