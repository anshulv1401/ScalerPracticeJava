package dev.anshul.bookmyshow.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theatre extends BaseModel {
    private String theatreName;
    private List<Screen> screens;
}
