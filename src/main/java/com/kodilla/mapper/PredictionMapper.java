package com.kodilla.mapper;

import com.kodilla.domain.Prediction;
import com.kodilla.dto.PredictionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PredictionMapper {

    @Mapping(target = "user", ignore = true)
    Prediction mapFromDto(final PredictionDto predictionDto);

    @Mapping(target = "userId", source = "user.id")
    PredictionDto mapToDto(final Prediction prediction);
}
