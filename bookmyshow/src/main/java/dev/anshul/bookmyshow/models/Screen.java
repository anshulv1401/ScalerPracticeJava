package dev.anshul.bookmyshow.models;

import java.util.List;

import dev.anshul.bookmyshow.models.emuns.Feature;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    private Long capacity;

}
