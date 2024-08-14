package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.domain.repository.UserRepository;
import az.edu.turing.usermanagementapp.exception.UserNotFoundException;
import az.edu.turing.usermanagementapp.mapper.UserMapper;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserAndProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import az.edu.turing.usermanagementapp.model.enums.ProfileStatus;
import az.edu.turing.usermanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public void create(UserRequestDto userDto) {
        UserEntity userEntity = userMapper.dtoToEntity(userDto);

        userEntity.setStatus(ProfileStatus.ACTIVATED);
        userEntity.setCreatedAt(LocalDateTime.now());

        userRepository.save(userEntity);
        logger.info("User {} {} was saved successfully", userDto.name(), userDto.surname());
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
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        userEntity.setName(userDto.name());
        userEntity.setSurname(userDto.surname());
        userEntity.setAge(userDto.age());
        userEntity.setUpdatedAt(LocalDateTime.now());

        userRepository.save(userEntity);
        logger.info("User {} {} with id {} was updated successfully", userDto.name(), userDto.surname(), id);

        return userMapper.entityToDto(userEntity);
    }

    @Override
    public Optional<UserAndProfileResponseDto> getUserAndProfiles(UUID id) {
        return Optional.empty();
    }
}