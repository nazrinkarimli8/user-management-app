package az.edu.turing.usermanagementapp.service;

import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    void save(UserRequestDto userDto);

    List<UserResponseDto> getAll();

    Optional<UserResponseDto> getById(UUID id);

    void deleteAll();

    void deleteById(UUID id);

    UserResponseDto update(UUID id, UserRequestDto userDto);

    Optional<UserResponseDto> getUserAndProfiles(UUID id);

    Optional<ProfileResponseDto> getProfile(UUID u_id, UUID p_id);

    Optional<ProfileResponseDto> updateProfile(UUID u_id, UUID p_id, ProfileRequestDto profileDto);

    void deleteProfile(UUID u_id, UUID p_id);
}
