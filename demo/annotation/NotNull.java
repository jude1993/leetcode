package annotation;

import java.lang.annotation.*;

/**
 * @author ：wupeng
 * @date ：Created in 13:39 2019/1/10
 * @description：
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull{

}
