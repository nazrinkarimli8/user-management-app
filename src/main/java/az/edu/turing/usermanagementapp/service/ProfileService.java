package az.edu.turing.usermanagementapp.service;

import az.edu.turing.usermanagementapp.model.dto.request.ProfileImageRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;

import java.util.Optional;
import java.util.UUID;

public interface ProfileService {

    //postRequest
    ProfileResponseDto createProfile(UUID u_id,ProfileRequestDto profileRequestDto);

    //getRequest
    Optional<ProfileResponseDto> getProfile(UUID u_id, UUID p_id);

    //putRequest
    Optional<ProfileResponseDto> updateProfile(UUID u_id, UUID p_id, ProfileRequestDto profileDto);

    //patchRequest
    Optional<ProfileResponseDto> updateProfileImage(UUID u_id, UUID p_id, ProfileImageRequestDto profileImageRequestDto);

    //deleteRequest
    void deleteProfile(UUID u_id, UUID p_id);
}
