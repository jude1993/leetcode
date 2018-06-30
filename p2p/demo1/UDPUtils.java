import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public interface UDPUtils {

    //回复内容
    static void sendMessage(String reportMessage, InetAddress address, int port, DatagramSocket client){
        try{
            byte[] sendBuf = reportMessage.getBytes();
        DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, address, port);
        client.send(packet);
        System.out.println("消息发送成功");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
