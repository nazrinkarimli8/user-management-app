package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.domain.repository.UserRepository;
import az.edu.turing.usermanagementapp.exception.UserNotFoundException;
import az.edu.turing.usermanagementapp.mapper.UserMapper;
import az.edu.turing.usermanagementapp.model.dto.UserDto;
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
    public void save(UserDto userDto) {
        UserEntity userEntity = userMapper.dtoToEntity(userDto);
        userRepository.save(userEntity);
        logger.info("User saved: {}", userEntity);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDto> userDto = userMapper.entityToDto(users);
        logger.info("Fetched all users");
        return userDto;
    }

    @Override
    public Optional<UserDto> getById(UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            logger.info("User found with id: {}", id);
        } else {
            logger.warn("User not found with id: {}", id);
            throw new UserNotFoundException("User not found with id: " + id);
        }
        return Optional.of(userMapper.entityToDto(user.get()));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
        logger.info("All users deleted");
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
        logger.info("User deleted with id: {}", id);
    }

    @Override
    public UserDto update(UUID id, UserDto userDto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAge(userDto.getAge());
        user.setStatus();
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

    }
}