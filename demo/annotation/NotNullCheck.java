package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ：wupeng
 * @date ：Created in 13:45 2019/1/10
 * @description：
 */
public class NotNullCheck implements NotNull ,BaseCheck{
    @Override
    public Class<? extends Annotation> annotationType() {
        return NotNullCheck.class;
    }

    @Override
    public <T>boolean check(T o) {
        Field[] fields = o.getClass().getDeclaredFields();
        try{
            for(Field field : fields){
                NotNull annotation = field.getAnnotation(NotNull.class);
                if(annotation != null){
                    Method method = o.getClass().getMethod(Utils.getMethodNameByField(field.getName(), "get"));
                    String result = method.invoke(o).toString();
                    if(result == null){
                        throw new RuntimeException(field.getName() + "cannot be null");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
