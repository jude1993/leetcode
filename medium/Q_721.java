import java.util.*;

/**
 * https://leetcode-cn.com/problems/accounts-merge/
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * */
public class Q_721 {
    public static void main(String[] args) {
        String cookieDomain = "http://t1-admin.51gonggui.com";
        int pos = cookieDomain.indexOf('.');
        if (pos > -1 && cookieDomain.contains("gonggui")) {
            cookieDomain = cookieDomain.substring(pos + 1, cookieDomain.length());
        }
        System.out.println(cookieDomain);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<List<String>>> map = new HashMap<>();
        for(int i = 0; i<accounts.size(); i++){
            List<String> list = accounts.get(i);
            if(map.containsKey(list.get(0))){
                List<List<String>> set = map.get(list.get(0));
                set.add(list);
            }else{
                List<List<String>> set = new LinkedList<>();
                set.add(list);
                map.put(list.get(0), set);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for(Map.Entry<String, List<List<String>>> en : map.entrySet()){
            String key = en.getKey();
            List<List<String>> value = en.getValue();
            if(value.size() <= 1){
                result.add(value.get(0));
            }else{
                /*if(){

                }*/
            }
        }
        return result;
    }


}
