import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：wupeng
 * @date ：Created in 10:38 2019/1/2
 * @description：
 */
public class LogDemo {

    public static void main(String[] args) {

        Log2 log = new Log2();
        log.info("hello");
    }
}

class Log {

    public void info(String msg) {
        System.out.println(String.format("%s | %s", getCaller(), msg));
    }

    public String getCaller() {
        StackTraceElement[] arr = (new Throwable()).getStackTrace();
        //打印格式: date | thread | class | msg
        StringBuilder sb = new StringBuilder(100);
        sb.append(getDate()).append(" | ").append(Thread.currentThread().getName()).append(" | ")
                .append(arr[2].getClassName()).append('(').append(arr[2].getMethodName()).append(':').append(arr[2].getLineNumber()).append(')');
        return sb.toString();
    }

    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}

class Log2{
    public void info(String msg) {
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        System.out.println(String.format("%s | %s", inferCaller(arr), msg));
    }

    public String inferCaller(StackTraceElement[] arr) {
        //打印格式: date | thread | class | msg
        StringBuilder sb = new StringBuilder(100);
        sb.append(getDate()).append(" | ").append(Thread.currentThread().getName()).append(" | ")
                .append(arr[2].getClassName()).append('(').append(arr[2].getMethodName()).append(':').append(arr[2].getLineNumber()).append(')');
        Utils.printCallStatck();
        return sb.toString();
    }

    public String getDate() {

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
