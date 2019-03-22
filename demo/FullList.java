import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：wupeng
 * @date ：Created in 9:23 2018/8/31
 * @description：动态规划 字符全排列
 */
public class FullList {
  public static void main(String[] args) {
    char[] charArr = new char[] {'a', 'c', 'z', 'l', 't'};
    for (int i = 0; i < charArr.length; i++) {
      StringBuffer buffer = new StringBuffer();
      for (int j = i + 1; j < charArr.length; j++) {}
    }
  }

  @Test
  public void format() {
    Date date = new Date(1543421460000L);
    String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    System.out.println(format);
  }


}
