package az.edu.turing.usermanagementapp.service;

import az.edu.turing.usermanagementapp.model.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    void save(UserDto userDto);

    List<UserDto> getAll();

    Optional<UserDto> getById(UUID id);

    void deleteAll();

    void deleteById(UUID id);

   UserDto update(UUID id, UserDto userDto);
}
