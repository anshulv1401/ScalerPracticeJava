package dev.anshul.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {

    private String name;
    private String description;
    // private List<String> languages;
}
