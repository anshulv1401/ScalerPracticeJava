package dev.anshul.bookmyshow.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BCryptPasswordEncoderConfig {

    // Beans are spring objects managed by bean
    @Bean
    public BCryptPasswordEncoder getEncoder() {

        return new BCryptPasswordEncoder();
    }
}
