package dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：wupeng`
 * @date ：Created in 14:46 2019/1/10
 * @description：
 */
public class ProxySubject implements InvocationHandler {

    private Object target;

    ProxySubject(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("before invoke");
        Object invoke = method.invoke(target, args);
    System.out.println("after invoke");
        return invoke;
    }
}
