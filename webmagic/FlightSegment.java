import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 搜索条件
 */
@Getter
@Setter
@ToString
public class FlightSegment {
    private String departureDate;
    private String arrivalProvinceId;
    private String arrivalCountryName;
    private String departureCityName;
    private String departureCityCode;
    private String departureCountryName;
    private String arrivalCityName;
    private String arrivalCityCode;
    private Integer arrivalCountryId;
    private Integer timeZone;
    private Integer departureCityId;
    private Integer departureCountryId;
    private Integer departureProvinceId;
    private Integer arrivalCityId;
}
