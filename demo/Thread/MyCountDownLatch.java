package Thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：wupeng
 * @date ：Created in 13:52 2019/3/14
 * @description：
 */
public class MyCountDownLatch {

  public static void main(String[] args) {

      ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
      ExecutorService executorService = new ThreadPoolExecutor(5, 20, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100), factory, new ThreadPoolExecutor.AbortPolicy());
      MyCountDownLatch latch = new MyCountDownLatch();
      latch.doExecutor(executorService);
  }

  private void doExecutor(ExecutorService executorService){
      List<FutureTask<MyCall>> tasks = new ArrayList<>();
      for(int i=0; i<20; i++){
          MyCall myCall = new MyCall("Thread-" + i);
          FutureTask<MyCall> task = new FutureTask<MyCall>(myCall);
          executorService.submit(task);
          tasks.add(task);
      }

      try{
          for(FutureTask task : tasks){
              task.get();
          }
      System.out.println("主线程执行完毕。。。。。");
      }catch (Exception e){

      }finally{
          if(!executorService.isShutdown()){
              executorService.shutdown();
          }
      }


  }

  private class MyCall implements Callable{

      private String name;

      private MyCall(String name){
        this.name = name;
      }

      @Override
      public Boolean call() {
      System.out.println(name+"进入");
          try {
              Thread.sleep(1000L);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(name+" sleep 结束");
          return true;
      }

  }
}
