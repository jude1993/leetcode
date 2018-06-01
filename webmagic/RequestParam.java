import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 *  请求参数
 * */
@Getter
@Setter
@ToString
public class RequestParam {
    private String flightWayEnum;
    private Integer arrivalProvinceId;
    private String arrivalCountryName;
    private Integer infantCount;
    private String cabin;
    private String cabinEnum;
    private String departCountName;
    private List<FlightSegment> flightSegments;
    private Integer childCount;
    private Integer segmentNo;
    private Integer adultCount;
    private String transactionId;
    private String directFlight;
    private Integer isMultiplePassengerType;
    private String flightWay;
    private Integer departProvinceId;
}
