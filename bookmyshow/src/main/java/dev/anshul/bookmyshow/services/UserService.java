package dev.anshul.bookmyshow.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.anshul.bookmyshow.exceptions.UserAlreadyPresent;
import dev.anshul.bookmyshow.models.User;
import dev.anshul.bookmyshow.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(String name, String email, String password) {

        var optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent())
            throw new UserAlreadyPresent("User with this email is already present");

        var user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
        return user;
    }
}
