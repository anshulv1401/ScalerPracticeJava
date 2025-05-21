package dev.anshul.bookmyshow.dtos;

import dev.anshul.bookmyshow.models.User;
import lombok.Data;

@Data
public class SignUpResponseDto {
    private User user;
    private ResponseStatus responseStatus;
}
