package ping;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/** @ Author ：wupeng
 *  @ Date ：Created in 10:58 2018/7/27
 *  @ Description：
 * */
public class AutoPing {
    private static final Logger logger = LoggerFactory.getLogger(AutoPing.class);
    private static String path = "https://www.vultr.com/faq/#downloadspeedtests";
    private static String elementId = "speedtest_v4";
    private static String attr = "href";

  public static void main(String[] args) {
    try {
      long start = System.currentTimeMillis();
      List<List<String>> collect =
          Jsoup.parse(new URL(path), 1000)
              .getElementById(elementId)
              .childNodes()
              .parallelStream()
              .filter(node -> node.childNodes().size() == 6)
              .map(
                  node -> {
                    String address = node.childNode(1).childNode(0).toString();
                    String ip = node.childNode(3).childNode(1).attr(attr);
                    List<String> str = null;
                    try {
                      str = PingUtils.ping02(ip.substring(ip.lastIndexOf('/') + 1), address);
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                    return str;
                  })
              .collect(Collectors.toList());
      print(collect);
      System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void print(List<List<String>> list) {
    list.forEach(l -> l.forEach(System.out::println));
  }
}
