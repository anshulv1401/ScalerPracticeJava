package dev.anshul.bookmyshow.models;

import java.util.List;

import dev.anshul.bookmyshow.models.emuns.Feature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Screen extends BaseModel {
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
    private Long capacity;

}
