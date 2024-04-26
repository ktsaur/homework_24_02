package Transport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeatureProperties {
    private String type;
    @JsonProperty("TrajectorySegmentMetaData")
    private TrajectorySegmentMetaData trajectorySegmentMetaData;
}
