package annotation;

/**
 * @author ：wupeng
 * @date ：Created in 11:03 2019/1/10
 * @description：
 */
public class Test {
  public static void main(String[] args) {
      User user = UserFactory.create();
    System.out.println(user);
  }
}
