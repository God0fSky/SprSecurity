package com.example.sprsecurity.services;


import com.example.sprsecurity.dtos.UserDto;
import com.example.sprsecurity.mappers.UserMapper;
import com.example.sprsecurity.models.User;
import com.example.sprsecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        userDto.setId(user.getId());
        log.info("User with id = " + userDto.getId() + "was successfully added!");
        return userDto;
    }

}
