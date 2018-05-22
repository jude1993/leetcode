/**
 * Created by jude on 2018/4/19.
 *
 * 类加载 顺序  先加载父类，后加载子类
 * 加载类的时候就执行 static 代码块
 * 调用构造函数的时候 先super() 代码块
 */
public class Interview {
    public static void main(String[] args){
        new Child();
    }
}



class Child extends Parent{
    {
        System.out.println("child class");
    }

    static{
        System.out.println("child class static");
    }
    public Child(){
        System.out.println("child 构造");
    }
}

class Parent{
    {
        System.out.println("parent class");
    }
    static{
        System.out.println("parent class static");
    }

    public Parent(){
        System.out.println("parent class 构造");
    }
}