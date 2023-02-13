package com.example.sprsecurity.mappers;


import com.example.sprsecurity.dtos.UserDto;
import com.example.sprsecurity.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);
    UserDto toUserDto(User user);

}
