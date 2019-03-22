package annotation;

import java.lang.annotation.*;

/**
 * @author ：wupeng
 * @date ：Created in 10:28 2019/1/10
 * @description：
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    String value() default "";
}
