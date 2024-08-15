package az.edu.turing.usermanagementapp.mapper;

import az.edu.turing.usermanagementapp.domain.entity.ProfileEntity;
import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserAndProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "profiles", ignore = true)
    UserEntity dtoToEntity(UserRequestDto userRequestDto);

    @Mapping(target = "profiles", source = "profiles", qualifiedByName = "mapProfilesToIds")
    UserResponseDto entityToDto(UserEntity userEntity);

    List<UserResponseDto> entityListToResponseDto(List<UserEntity> userEntities);

    List<UserAndProfileResponseDto> entityListToResponseDtoList(List<UserEntity> userEntities);

    @Named("mapProfilesToIds")
    default List<UUID> mapProfilesToIds(List<ProfileEntity> profiles) {
        return profiles.stream()
                .map(ProfileEntity::getId)
                .collect(Collectors.toList());
    }
}
