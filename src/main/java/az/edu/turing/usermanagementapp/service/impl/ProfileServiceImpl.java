package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.model.dto.request.ProfileImageRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import az.edu.turing.usermanagementapp.service.ProfileService;

import java.util.Optional;
import java.util.UUID;

public class ProfileServiceImpl implements ProfileService {
    @Override
    public ProfileResponseDto createProfile(UUID u_id, ProfileRequestDto profileRequestDto) {
        return null;
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
