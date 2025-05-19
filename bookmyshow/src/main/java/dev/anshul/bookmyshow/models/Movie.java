package dev.anshul.bookmyshow.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends BaseModel {

    private String name;
    private String description;
    private List<String> languages;
}
