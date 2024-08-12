package az.edu.turing.usermanagementapp.service;

import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserAndProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    //postRequest
    void save(UserRequestDto userDto);

    //getRequest
    List<UserResponseDto> getAll();

    //getRequest
    Optional<UserResponseDto> getById(UUID id);

    //deleteRequest
    void deleteAll();

    //deleteRequest
    void deleteById(UUID id);

    //putRequest
    UserResponseDto update(UUID id, UserRequestDto userDto);

    //getRequest
    Optional<UserAndProfileResponseDto> getUserAndProfiles(UUID id);

    // update
}
