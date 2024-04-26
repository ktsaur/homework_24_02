package Transport.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter@Setter
public class Vehicle {
    private String type;
    private Properties properties;
    private List<Feature> features;
}
