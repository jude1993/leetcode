package station;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import ping.HttpClientUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：wupeng
 * @date ：Created in 16:59 2018/8/31
 * @description：
 */
public class Demo {
  static String path =
      "https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=1.9063";
  static String path2 =
      "https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2018-10-04&leftTicketDTO.from_station=SHH&leftTicketDTO.to_station=MQF&purpose_codes=ADULT";

  public static void main(String[] args) throws IOException {}

  public static List<String[]> station() {
    String content = HttpClientUtils.get(path);
    content = content.substring(content.lastIndexOf('=') + 1, content.lastIndexOf("'"));
    List<String[]> collect =
        Arrays.stream(content.split("@"))
            .map(str -> str.split("\\|"))
            .filter(strArr -> strArr.length > 1)
            .collect(Collectors.toList());
    System.out.println(collect);
    return collect;
  }

  public static List<String[]> list() {
    String json = HttpClientUtils.get(path2);
    QueryResponse queryResponse = JSONObject.parseObject(json, QueryResponse.class);
    assert queryResponse != null;
    return queryResponse
        .getData()
        .getResult()
        .stream()
        .map(str -> str.split("\\|"))
        .filter(strArr -> strArr.length > 1)
        .collect(Collectors.toList());
  }

  @Test
  public void timeTest() {
    String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1538668800000L));
    System.out.println(format);
  }
}
