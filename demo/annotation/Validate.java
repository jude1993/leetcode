package annotation;

import java.lang.annotation.*;

/**
 * @author ：wupeng
 * @date ：Created in 11:05 2019/1/10
 * @description：
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    int min() default 1;
    int max() default 10;
    boolean isNotNull() default true;

}
