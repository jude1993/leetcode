package io;

/**
 * @author ：wupeng
 * @date ：Created in 17:02 2019/1/8
 * @description：
 */
public class CountUtils {

    /**
     * 计算百分比值
     * */
    public static Long count(Long num, Long percent){
        if(num < 0 || percent < 1){
            return 0L;
        }
        Double percentNum = (double) (percent / 100);
        return (long)(num * percentNum);
    }

}
