package az.edu.turing.usermanagementapp.mapper;

import az.edu.turing.usermanagementapp.domain.entity.ProfileEntity;
import az.edu.turing.usermanagementapp.model.dto.ProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileDto entityToDto(ProfileEntity profileEntity);
    ProfileEntity dtoToEntity(ProfileDto profileDto);
    List<ProfileDto> entityToDto(List<ProfileEntity> profileEntity);
    List<ProfileEntity> dtoToEntity(List<ProfileDto> profileDto);

    @Mapping(target = "id", ignore = true)
    ProfileDto createProfileDtoWithoutId(ProfileEntity profileEntity);
}
