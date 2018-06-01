import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultMessage {
    private Integer status;
    private String msg;
    private FlightResponseDate data;
}
