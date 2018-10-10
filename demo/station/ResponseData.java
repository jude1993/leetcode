package station;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @author ：wupeng
 * @date ：Created in 15:16 2018/9/5
 * @description：
 */
@Getter
@Setter
@ToString
public class ResponseData {
  private String flag;
  private Map<String, String> map;
  private List<String> result;
}
