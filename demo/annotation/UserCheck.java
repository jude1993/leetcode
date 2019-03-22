package annotation;

import java.lang.reflect.Field;

/**
 * @author ：wupeng
 * @date ：Created in 11:11 2019/1/10
 * @description：
 */
public class UserCheck {
    public boolean check(User user){
        if(user == null){
            return false;
        }
        //获取User类的所有属性
        Field[] fields = User.class.getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Validate.class)){
                Validate annotation = field.getAnnotation(Validate.class);
                if("ages".equals(field.getName())){

                }
            }
        }
        return false;
    }
}
