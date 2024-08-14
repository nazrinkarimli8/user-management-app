package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.domain.entity.ProfileEntity;
import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.domain.repository.ProfileRepository;
import az.edu.turing.usermanagementapp.domain.repository.UserRepository;
import az.edu.turing.usermanagementapp.exception.UserNotFoundException;
import az.edu.turing.usermanagementapp.mapper.ProfileMapper;
import az.edu.turing.usermanagementapp.model.dto.request.ProfileImageRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import az.edu.turing.usermanagementapp.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileResponseDto createProfile(UUID u_id, ProfileRequestDto profileRequestDto) {
        UserEntity userEntity = userRepository.findById(u_id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + u_id));

        logger.info("Creating profile for user with id: {}", u_id);
        ProfileEntity profileEntity = profileMapper.toProfileEntity(profileRequestDto);
        profileEntity.setUser(userEntity);
        ProfileEntity savedProfile = profileRepository.save(profileEntity);

        logger.info("Profile created with id: {}", savedProfile.getId());
        return profileMapper.toProfileResponseDto(savedProfile);
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
    public Optional<ProfileResponseDto> updateProfileImage(UUID u_id, UUID p_id, ProfileImageRequestDto profileImageRequestDto) {
        return Optional.empty();
    }

    @Override
    public void deleteProfile(UUID u_id, UUID p_id) {

    }
}
