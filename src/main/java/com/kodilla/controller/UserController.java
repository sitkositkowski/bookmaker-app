package com.kodilla.controller;

import com.kodilla.dto.UserDto;
import com.kodilla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<>();
        users.add(UserDto.builder()
                .id(1L)
                .name("Test user")
                .build());
        return users;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return UserDto.builder()
                .id(1L)
                .name("Test user")
                .build();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return UserDto.builder()
                .id(1L)
                .name("Test user")
                .build();
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return UserDto.builder()
                .id(1L)
                .name("Test user")
                .build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
