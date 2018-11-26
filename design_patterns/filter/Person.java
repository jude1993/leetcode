package filter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：wupeng
 * @date ：Created in 15:26 2018/10/8
 * @description：
 */
@Getter
@Setter
@ToString
public class Person {
  private String name;
  private String gender;
  private String maritalStatus;

  public static void main(String[] args) {
    Double a = 1.2;
    Double b = 1.2;
    System.out.println(a + b);
  }
}
