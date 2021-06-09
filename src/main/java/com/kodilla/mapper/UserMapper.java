package com.kodilla.mapper;

import com.kodilla.domain.User;
import com.kodilla.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapFromDto(final UserDto userDto);

    UserDto mapToDto(final User user);

}
