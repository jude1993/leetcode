package mobile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResponseObject {
    private ResponseStatus responseStatus;
    private List<FlightDetail> fltitem;
    private String cityclass;
    private Integer rlt;
    private String rltmsg;
    private Integer lpainIndex;
    private Integer lpricetax;

}

@Getter
@Setter
@ToString
class ResponseStatus{
    private String timestamp;
    private String ack;

    private List<String> errors;
    private String build;
    private String version;
    private List<Extension> extensions;
}

@Getter
@Setter
@ToString
class Extension{
    String id;
    String version;
    String contentType;
    String value;
}