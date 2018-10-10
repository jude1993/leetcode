package station;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ：wupeng
 * @date ：Created in 15:14 2018/9/5
 * @description：
 */
@Getter
@Setter
@ToString
public class QueryResponse {
  private ResponseData data;
  private String httpstatus;
  private String message;
  private Boolean status;
}
