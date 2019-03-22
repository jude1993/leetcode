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

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Map<String, String> getMap() {
    return map;
  }

  public void setMap(Map<String, String> map) {
    this.map = map;
  }

  public List<String> getResult() {
    return result;
  }

  public void setResult(List<String> result) {
    this.result = result;
  }
}
