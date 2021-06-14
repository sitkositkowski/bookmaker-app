package com.kodilla.backend.mapper;

import com.kodilla.backend.domain.User;
import com.kodilla.backend.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapFromDto(final UserDto userDto);

    UserDto mapToDto(final User user);

}
