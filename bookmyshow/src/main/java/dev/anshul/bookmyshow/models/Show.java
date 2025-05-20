package dev.anshul.bookmyshow.models;

import java.util.List;

import dev.anshul.bookmyshow.models.emuns.Feature;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;
    private Long startTime;
    private Long endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
