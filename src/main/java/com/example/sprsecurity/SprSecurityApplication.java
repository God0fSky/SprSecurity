package com.example.sprsecurity;

import com.example.sprsecurity.dtos.UserDto;
import com.example.sprsecurity.models.UserRole;
import com.example.sprsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SprSecurityApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SprSecurityApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        userService.addUser(new UserDto(null, "TestAdmin", "admin", UserRole.ADMIN));

    }


}
