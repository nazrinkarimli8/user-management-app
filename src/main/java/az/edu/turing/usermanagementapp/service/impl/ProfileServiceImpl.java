package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.domain.entity.ProfileEntity;
import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.domain.repository.ProfileRepository;
import az.edu.turing.usermanagementapp.domain.repository.UserRepository;
import az.edu.turing.usermanagementapp.exception.ProfileNotFoundException;
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
        UserEntity userEntity = userRepository.findById(u_id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + u_id));

        Optional<ProfileEntity> profileEntity = profileRepository.findById(p_id)
                .filter(profile -> profile.getUser().getId().equals(u_id));

        if (profileEntity.isPresent()) {
            logger.info("Profile found with id: {} for user with id: {}", p_id, u_id);
            return Optional.of(profileMapper.toProfileResponseDto(profileEntity.get()));
        } else {
            logger.warn("Profile with id: {} not found or does not belong to user with id: {}", p_id, u_id);
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProfileResponseDto> updateProfile(UUID u_id, UUID p_id, ProfileRequestDto profileDto) {

        ProfileEntity existingProfile = profileRepository.findById(p_id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + p_id));

        existingProfile.setNickname(profileDto.nickname());
        existingProfile.setPassword(profileDto.password());
        existingProfile.setEmail(profileDto.email());
        existingProfile.setProfilePhoto(profileDto.profilePhoto());

        ProfileEntity updatedProfile = profileRepository.save(existingProfile);

        ProfileResponseDto profileResponseDto = profileMapper.toProfileResponseDto(updatedProfile);

        return Optional.of(profileResponseDto);
    }


    @Override
    public Optional<ProfileResponseDto> updateProfileImage(UUID u_id, UUID p_id, ProfileImageRequestDto profileImageRequestDto) {
        ProfileEntity existingProfile = profileRepository.findById(p_id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + p_id));

        existingProfile.setProfilePhoto(profileImageRequestDto.userImage());

        ProfileEntity updatedProfile = profileRepository.save(existingProfile);

        ProfileResponseDto profileResponseDto = profileMapper.toProfileResponseDto(updatedProfile);

        return Optional.of(profileResponseDto);
    }

    @Override
    public void deleteProfile(UUID u_id, UUID p_id) {

    }
}
