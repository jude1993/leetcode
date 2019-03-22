package dynamic;

import java.lang.reflect.Proxy;

/**
 * @author ：wupeng
 * @date ：Created in 14:56 2019/1/10
 * @description：
 */
public class Test {
  public static void main(String[] args) {
      Subject subject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(), new ProxySubject(new RealSubject()));
      subject.doSome();
    System.out.println(subject.getClass().getName());
  }
}
