import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wupeng
 * @date ：Created in 10:48 2018/8/29
 * @description：
 */
public class OOMDump {

  static class OOMIntsmaze {
    public byte[] placeholder = new byte[64 * 1024];
  }

  public static void fillHeap(ArrayList<OOMIntsmaze> list, int num) throws Exception {

    for (int i = 0; i < num; i++) {
      list.add(new OOMIntsmaze());
      System.out.println(i);
    }
  }

  public static void main(String[] args) throws Exception {
    ArrayList<OOMIntsmaze> list = new ArrayList<OOMIntsmaze>();
    fillHeap(list, 131);
    Map<String, OOMIntsmaze> map = new HashMap<String, OOMIntsmaze>();
    map.put("LIUYANG", new OOMIntsmaze());
    map.put("intsmaze", new OOMIntsmaze());
    Thread.sleep(20000000);
  }

  public static void memory() {
    long memory = Runtime.getRuntime().maxMemory();
    System.out.println(memory);
  }
}
