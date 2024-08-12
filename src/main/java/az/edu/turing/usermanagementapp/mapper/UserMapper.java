package az.edu.turing.usermanagementapp.mapper;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserAndProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity dtoToEntity(UserRequestDto userRequestDto);

    UserResponseDto entityToDto(UserEntity userEntity);

    UserAndProfileResponseDto entityToResponseDto(UserEntity userEntity);

    List<UserResponseDto> entityListToResponseDto(List<UserEntity> userEntities);

    List<UserAndProfileResponseDto> entityListToResponseDtoList(List<UserEntity> userEntities);
}
