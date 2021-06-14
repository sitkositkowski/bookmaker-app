package com.kodilla.backend.mapper;

import com.kodilla.backend.domain.Prediction;
import com.kodilla.backend.dto.PredictionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PredictionMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "match", ignore = true)
    Prediction mapFromDto(final PredictionDto predictionDto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "matchId", source = "match.id")
    PredictionDto mapToDto(final Prediction prediction);
}
