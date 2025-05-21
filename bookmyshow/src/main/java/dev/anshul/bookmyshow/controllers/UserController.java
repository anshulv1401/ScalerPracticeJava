package dev.anshul.bookmyshow.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.anshul.bookmyshow.dtos.ResponseStatus;
import dev.anshul.bookmyshow.dtos.SignUpRequestDto;
import dev.anshul.bookmyshow.dtos.SignUpResponseDto;
import dev.anshul.bookmyshow.services.UserService;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto request) {

        var response = new SignUpResponseDto();
        try {
            var user = userService.signUp(request.getName(), request.getEmail(), request.getPassword());
            response.setUser(user);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            return response;

        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
    }
}
