package com.kodilla.backend.mapper;

import com.kodilla.backend.domain.User;
import com.kodilla.backend.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserMapperTestSuite {

    @Autowired
    UserMapper userMapper;

    @Test
    void testMapFromDto() {
        //Given
        UserDto userDto =  new UserDto(1L,"Test user");
        //When
        User user = userMapper.mapFromDto(userDto);
        //Then
        assertEquals(1L, user.getId());
        assertEquals("Test user", user.getName());
    }

    @Test
    void testMapToDto() {
        //Given
        User user =  new User(1L,"Test user");
        //When
        UserDto userDto = userMapper.mapToDto(user);
        //Then
        assertEquals(1L, userDto.getId());
        assertEquals("Test user", userDto.getName());
    }
}
