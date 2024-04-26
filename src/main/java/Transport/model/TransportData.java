package Transport.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransportData {
    private List<Vehicle> vehicles;
    private RegionInfo regionInfo;
}
