package dev.anshul.bookmyshow.models;

import java.util.List;

import dev.anshul.bookmyshow.models.emuns.Feature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Show extends BaseModel {

    private Movie movie;
    private Long startTime;
    private Long endTime;
    private List<Feature> features;
}
