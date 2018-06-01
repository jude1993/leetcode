import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FlightResponseDate {
    private Context context;
    private List<FlightItinerary> flightItineraryList;
    private List<Object> couponAdditionList;



    class Context{
        private String searchId;
        private Boolean finished;
        private Integer flag;
    }

    class FlightItinerary{
        private String itineraryId;
        private List<FlightSegment> flightSegments;
    }
}
