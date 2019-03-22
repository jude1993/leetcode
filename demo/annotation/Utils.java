package annotation;

/**
 * @author ：wupeng
 * @date ：Created in 14:14 2019/1/10
 * @description：
 */
public class Utils {

    public static String getMethodNameByField(String field,String methodType){
        return methodType + field.substring(0, 1).toUpperCase() + field.substring(1);
    }
}
