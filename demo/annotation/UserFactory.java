package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：wupeng
 * @date ：Created in 10:34 2019/1/10
 * @description：构造工厂充当注释解析器
 */
public class UserFactory {
    public static User create(){
        User user = new User();
        Method[] methods = user.getClass().getMethods();
        try {
            for(Method method : methods){
            if(method.isAnnotationPresent(Init.class)){
                Init annotation = method.getAnnotation(Init.class);
                    method.invoke(user,annotation.value());
            }
        }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

}
