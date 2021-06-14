package com.kodilla.backend.service;

import com.kodilla.backend.mapper.UserMapper;
import com.kodilla.backend.domain.User;
import com.kodilla.backend.dto.UserDto;
import com.kodilla.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        return userRepository.findAll(Sort.by("name"))
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> getUserById(final Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapToDto);
    }

    public UserDto saveUser(final UserDto userDto) {
        User user = userMapper.mapFromDto(userDto);
        user = userRepository.save(user);
        return userMapper.mapToDto(user);
    }

    public Optional<UserDto> updateUser(final UserDto userDto) {
        Optional<User> user = userRepository.findById(userDto.getId());
        if (user.isPresent()) {
            user.ifPresent(u -> {
                u.setName(userDto.getName());
            });
            System.out.println(user);
            User savedUser = userRepository.save(user.get());
            return Optional.of(savedUser).map(userMapper::mapToDto);
        }
        return Optional.empty();
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }

}
