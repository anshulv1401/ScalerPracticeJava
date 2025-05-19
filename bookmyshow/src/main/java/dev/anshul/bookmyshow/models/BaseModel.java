package dev.anshul.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {
    private Long id;
    private Long createdAt;
    private Long lastModifiedAt;
}
