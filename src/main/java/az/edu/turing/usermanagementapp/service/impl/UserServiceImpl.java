package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.domain.repository.UserRepository;
import az.edu.turing.usermanagementapp.mapper.UserMapper;
import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import az.edu.turing.usermanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserRequestDto userDto) {

    }

    @Override
    public List<UserResponseDto> getAll() {
        return List.of();
    }

    @Override
    public Optional<UserResponseDto> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public UserResponseDto update(UUID id, UserRequestDto userDto) {
        return null;
    }

    @Override
    public Optional<UserResponseDto> getUserAndProfiles(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProfileResponseDto> getProfile(UUID u_id, UUID p_id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProfileResponseDto> updateProfile(UUID u_id, UUID p_id, ProfileRequestDto profileDto) {
        return Optional.empty();
    }

    @Override
    public void deleteProfile(UUID u_id, UUID p_id) {

    }
}