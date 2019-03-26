package Thread;

/**
 * @author ：wupeng
 * @date ：Created in 15:28 2019/3/25
 * @description：
 */
public class StaticDemo7 {

    public static void main(String[] args) {
        System.out.println(E.i);
        System.out.println(E.j);
    }

}

class E {


    static E e = new E();// 1
    static int i = 5;// 2
    static int j;// 3
    static {
        System.out.println("static" + i);
        E.i++;
        System.out.println("static" + i);
        E.j++;
    }

    public E() {
    System.out.println("new"+i);
        i++;
    System.out.println("new"+i);
        j++;
    }

}