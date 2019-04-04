/**
 * @author ：wupeng
 * @date ：Created in 14:17 2019/4/4
 * @description：
 */
public class RetryDemo {
  public static void main(String[] args) {
      int i = 0;
     RT:
      while(true){
        System.out.println(i++);
        int j=0;
        T:
        for(;;){
          System.out.println(j++);
          if(j == 4){
              continue T;
          }
          if(i==5){
              break RT;
          }
        }
      }
  }
}
