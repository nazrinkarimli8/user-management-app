package az.edu.turing.usermanagementapp.service;

import az.edu.turing.usermanagementapp.model.dto.ProfileDto;
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

    Optional<UserDto> getUserAndProfiles(UUID id);

    Optional<UserDto> getProfile(UUID u_id, UUID p_id);

    Optional<UserDto> updateProfile(UUID u_id, UUID p_id, ProfileDto profileDto);

    void deleteProfile(UUID u_id, UUID p_id);
}
