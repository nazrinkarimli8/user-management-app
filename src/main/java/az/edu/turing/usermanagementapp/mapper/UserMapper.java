package az.edu.turing.usermanagementapp.mapper;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

   //todo  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto entityToDto(UserEntity userEntity);
    UserEntity dtoToEntity(UserDto userDto);
    List<UserDto> entityToDto(List<UserEntity> userEntity);
    List<UserEntity> dtoToEntity(List<UserDto> userDto);

    @Mapping(target = "id", ignore = true)
    UserDto createUserDtoWithoutId(UserEntity userEntity);
}
