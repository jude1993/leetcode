package classLoder;

/**
 * @author ：wupeng
 * @date ：Created in 11:03 2019/1/7
 * @description：
 */
public class LoaderDemo {
  public static void main(String[] args) {
      LoaderDemo loader = new LoaderDemo();
      loader.printLoader();
  }

  public void printLoader(){
    System.out.println("this class is loader by " + getClass().getClassLoader().getClass());
  }
}
