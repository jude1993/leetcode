package Thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author jude
 * @date 2019/4/2 23:48
 * @description:
 */
public class Demo {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        Demo demo = new Demo();
        try {
            demo.doProcess(executor);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(!executor.isShutdown()){
                executor.shutdown();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public void doProcess(ExecutorService executor) throws ExecutionException, InterruptedException {
        List<Future<Boolean>> list = new LinkedList<>();
        for(int i=0; i<100; i++){
            Mytask mytask = new Mytask(i);
            FutureTask<Boolean> task = new FutureTask<Boolean>(mytask);
            list.add(task);
            executor.submit(task);
        }
        for(Future<Boolean> task : list){
            task.get();
        }
    }

    class Mytask implements Callable{

        private int i;

        public Mytask(int i){
            this.i = i;
        }

        @Override
        public Boolean call() {
            try {
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + "---->"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}


