package mobile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Mutilstn {
    private Integer segno;
    private Integer seqid;
    private Dportinfo dportinfo;
    private Aportinfo aportinfo;
    private BasInfo basinfo;
    private CraftInfo craftinfo;
    private DateInfo dateinfo;

}

@Getter
@Setter
@ToString
class Dportinfo{
    private String aport;
    private String aportsname;
    private String cityname;
    private String city;
    private String bsname;
    private String cityid;
}

@Getter
@Setter
@ToString
class Aportinfo{
    private String aport;
    private String aportsname;
    private String cityname;
    private String city;
    private String bsname;
    private String cityid;
}

@Getter
@Setter
@ToString
class BasInfo{
    private String aircode;
    private String airsname;
    private String flgno;
    private String ishared;
}

@Getter
@Setter
@ToString
class CraftInfo{
    private String craft;
    private String kind;
    private String cname;
}

@Getter
@Setter
@ToString
class DateInfo{
    private String ddate;
    private String dweek;
    private String adate;
    private String aweek;
    private Integer doday;
    private Integer aoday;

}
