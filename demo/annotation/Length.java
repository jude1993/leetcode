package annotation;

import java.lang.annotation.*;

/**
 * @author ：wupeng
 * @date ：Created in 13:41 2019/1/10
 * @description：
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {

}
