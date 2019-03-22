package annotation;

/**
 * @author ：wupeng
 * @date ：Created in 14:28 2019/1/10
 * @description：
 */
public class AopDemo{
  public static void main(String[] args) {
      print(new User());
  }

  public static void print(User user){
    System.out.println(user);
  }
}
