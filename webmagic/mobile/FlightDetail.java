package mobile;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class FlightDetail {
    private List<Mutilstn> mutilstn;
    private List<PolicyInfo> policyinfo;
    private Integer duration;
    private Integer fltoday;
    private Integer painindex;

}

@Getter
@Setter
@ToString
class PolicyInfo{
    private List<PriceInfo> priceinfo;
    private String pid;
}

@Getter
@Setter
@ToString
class PriceInfo{
    private Integer price;
    private Integer tax;
    private Integer ticket;
    private Map attr;
}