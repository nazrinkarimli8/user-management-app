package az.edu.turing.usermanagementapp.mapper;

import az.edu.turing.usermanagementapp.domain.entity.ProfileEntity;
import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileResponseDto toProfileResponseDto(ProfileEntity profileEntity);

    ProfileEntity toProfileEntity(ProfileRequestDto profileRequestDto);

    List<ProfileResponseDto> toProfileResponseDtoList(List<ProfileEntity> profileEntities);

    List<ProfileEntity> toProfileEntityList(List<ProfileRequestDto> profileRequestDtoList);
}
