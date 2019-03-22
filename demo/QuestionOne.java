import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：wupeng
 * @date ：Created in 17:00 2019/3/4
 * @description：
 */
public class QuestionOne {
    private static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

  public static void main(String[] args) throws ParseException {
        String d1 = "2019-02-19";
        String d2 = "2019-03-01";
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      Date date1 = format.parse(d1);
      Date date2 = format.parse(d2);
      long l = date2.getTime() - date1.getTime();
      long diff = l / (24 * 60 * 60 * 1000);
      System.out.println(diff);

    System.out.println(Long.parseLong("123"));
  }
}
