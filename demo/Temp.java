/**
 * @author ：wupeng
 * @date ：Created in 13:58 2019/2/21
 * @description：
 */
public class Temp {
    private String subSuffix(String name,String... suffix){
        for(String suf : suffix){
            if(name.endsWith(suf)){
                name = name.substring(0,name.length()-suf.length());
                return name;
            }
        }
        return name;
    }

    public static void main(String[] args){
        Temp trainSearchController = new Temp();
        String s = trainSearchController.subSuffix("济南东", "县", "市");
        System.out.println(s);
    }
}
