package Thread;

/**
 * @author ：wupeng
 * @date ：Created in 9:18 2019/4/4
 * @description：
 */
public class Demo2 {
  public static void main(String[] args) {

  }

  private void test(){
      Thread thread = new Thread("thread-1");
      Task task1 = new Task("task-1");
      Task task2 = new Task("task-2");

  }

  private class Task implements Runnable{
      private String name;

      public Task(String name){
          this.name = name;
      }

      @Override
      public void run() {
         System.out.println(this.name);
      }
  }
}
