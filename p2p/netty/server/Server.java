package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** @ Author ：wupeng @ Date ：Created in 16:34 2018/8/1 @ Description： */
public class Server {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) throws IOException {

    ServerSocket ss = new ServerSocket(8888);

    System.out.println("等待接收连接....");
    Socket socket = ss.accept();
    // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
    InputStream inputStream = socket.getInputStream();
    byte[] bytes = new byte[1024];
    int len;
    StringBuilder sb = new StringBuilder();
    // 只有当客户端关闭它的输出流的时候，服务端才能取得结尾的-1
    while ((len = inputStream.read(bytes)) != -1) {
      // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
      sb.append(new String(bytes, 0, len, "UTF-8"));
    }
    System.out.println(sb.toString());
    /*inputStream.close();
    socket.close();
    ss.close();*/
  }
}
