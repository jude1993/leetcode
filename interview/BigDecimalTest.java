import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：wupeng
 * @date ：Created in 14:01 2018/11/6
 * @description：
 */
public class BigDecimalTest {
  public static void main(String[] args) {
    System.out.println(0.2 + 0.1);
    System.out.println(0.3 - 0.1);
    System.out.println(0.2 * 0.1);
    System.out.println(0.3 / 0.1);
    Double d1 = 0.3;
    Double d2 = 0.1;
    System.out.println(d1 / d2);
    BigDecimal decimal1 = new BigDecimal(0.3);
    BigDecimal decimal2 = new BigDecimal(0.1);
    System.out.println(decimal1.divide(decimal2, 2, 4).doubleValue());
    System.out.println(decimal1.add(decimal2));
    System.out.println();
    Set<String> collect =
        Arrays.asList("A", "B", "C")
            .stream()
            .filter(str -> str.startsWith("A"))
            .collect(Collectors.toSet());
  }
}
