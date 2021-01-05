import org.junit.jupiter.api.Test;

/**
 * @Author: jude
 * @Date: Create in 15:25 2018/3/6
 * @Description: 二分查找
 */
public class BinarySearch {
    public <S extends Comparable> int search(S[] s, int start, int end, S target) {
        if(start > end){
            return -1;
        }
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (s[mid].compareTo(target)>0) {
            search(s,start,mid,target);
        }
        if(s[mid].compareTo(target)<0){
            search(s,mid,start,target);
        }
        return mid;
    }
    @Test
    public void testBinarySearch(){
        //TODO:
    }
}
