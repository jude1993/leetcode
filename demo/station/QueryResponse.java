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

  public ResponseData getData() {
    return data;
  }

  public void setData(ResponseData data) {
    this.data = data;
  }

  public String getHttpstatus() {
    return httpstatus;
  }

  public void setHttpstatus(String httpstatus) {
    this.httpstatus = httpstatus;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
