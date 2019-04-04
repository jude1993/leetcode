package Thread.ThreadPool;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ：wupeng
 * @date ：Created in 14:23 2019/3/29
 * @description：
 */
public class Demo3 {

  public static void main(String[] args) throws IOException {
    RandomAccessFile aFile =
        new RandomAccessFile(
            "nio-data.txt", "rw");
    FileChannel channel = aFile.getChannel();
    ByteBuffer buff = ByteBuffer.allocate(48);
    int read = channel.read(buff);
    while(read != -1){
      System.out.println("read "+read);
      buff.flip();
      while(buff.hasRemaining()){
        System.out.print((char)buff.get());
      }
      buff.clear();
      read = channel.read(buff);
    }
    aFile.close();
  }
}
