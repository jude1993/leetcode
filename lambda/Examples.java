import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: jude
 * @Date: Create in 14:58 2018/3/20
 * @Description:
 */
public class Examples {
    static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    /**
     * 1,实现runnable
     * 格式：(params) -> statement
     */
    @Test
    public void example_1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little");
            }
        }).start();

        new Thread(() -> System.out.println("In java8,lambda expression")).run();
    }

    /**
     * 2,使用lambda表达式进行事件处理
     */
    public void example_2() {
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression");
            }
        });

        show.addActionListener((e) -> {
            System.out.println("Light,Camera,Action!! Lambda expression");
        });
    }

    /**
     * 3,使用lambda表达式对列表进行迭代
     */
    @Test
    public void example_3() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        features.forEach(System.out::println);
    }

    /**
     * 4.使用lambda表达式和函数式接口Predicate
     */
    public void example_4() {
        List<String> languages = Arrays.asList("java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("language which starts with j:");
        filter(languages, (str) -> str.startsWith("J"));
        filter(languages, (str) -> str.endsWith("a"));
        filter(languages, (str) -> true);
        filter(languages, (str) -> false);
        filter(languages, (str) -> str.length() > 4);

    }

    /**
     * 5.如何在lambda表达式中加入Predicate 过滤
     */
    @Test
    public void example_5() {
        List<String> names = Arrays.asList("Java", "C++", "C#", "JavaScript", "C");
        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream().filter(startWithJ.and(fourLetterLong)).forEach(((n) -> System.out.println("name" + n)));
    }

    /**
     * 6.Java8中使用lambda表达式的Map和Reduce示例
     */
    @Test
    public void example_6() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }
        System.out.println("-------------");
        //使用lambda
        costBeforeTax.stream().map((cost) ->
                cost + .12 * cost).forEach(System.out::println);
    }

    @Test
    public void example_6_1() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total:" + total);

        Double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("total:" + bill);
    }

    /**
     * 7.通过过滤创建一个String列表
     */
    @Test
    public void example_7() {
        List<String> strList = Arrays.asList("str", "java", "va", "cc");
        List<String> collect = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 8.对列表的每个元素应用函数
     * */
    @Test
    public void example_8(){
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "German", "Italy", "U.K", "Canada");
        String collectStr = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(collectStr);
    }
    /**
     * 9.复制不同的值，创建一个子列表
     * */
    @Test
    public void example_9(){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> collect = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, collect);
    }

    /**
     * 10.计算集合元素的最大值，最小值，总和以及平均值
     * */
    @Test
    public void example_10(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 6, 11, 13, 17, 19);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest"+stats.getMax());
        System.out.println("Lowest"+stats.getMin());
        System.out.println("Sum"+stats.getSum());
        System.out.println("Average"+stats.getAverage());
    }
}
