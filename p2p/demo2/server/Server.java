package demo2.server;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/** @ Author ：wupeng @ Date ：Created in 14:14 2018/8/2 @ Description： */
public class Server {
  public static void main(String[] args) throws IOException {
    int port = 2018;

    ServerSocket server = new ServerSocket(port);
    Socket socket = server.accept();
    InetAddress address = socket.getInetAddress();
    InputStream inputStream = socket.getInputStream();
  }

  @Test
  public void spit() {
    String str = "a#b#";
    Boolean a = null;
    System.out.println(str.split("#").length);
    System.out.println(Boolean.valueOf(""));
    System.out.println(a ? 1 : 2);
  }
}
