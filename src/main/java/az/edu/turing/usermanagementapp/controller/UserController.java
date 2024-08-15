package az.edu.turing.usermanagementapp.controller;

import az.edu.turing.usermanagementapp.model.dto.request.ProfileImageRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import az.edu.turing.usermanagementapp.service.ProfileService;
import az.edu.turing.usermanagementapp.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDto userDto) {
        userService.create(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody UserRequestDto userDto) {
        UserResponseDto updatedUser = userService.update(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/{userId}/profiles")
    public ResponseEntity<ProfileResponseDto> createProfile(
            @PathVariable UUID userId,
            @Valid @RequestBody ProfileRequestDto profileRequestDto) {
        ProfileResponseDto createdProfile = profileService.createProfile(userId, profileRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
    }

    @GetMapping("/{userId}/profiles/{profileId}")
    public ResponseEntity<ProfileResponseDto> getProfile(
            @PathVariable UUID userId,
            @PathVariable UUID profileId) {
        Optional<ProfileResponseDto> profile = profileService.getProfile(userId, profileId);
        return profile.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{userId}/profiles/{profileId}")
    public ResponseEntity<Optional<ProfileResponseDto>> updateProfile( @PathVariable("userId") UUID u_id, @PathVariable("profileId") UUID p_id, @Valid @RequestBody ProfileRequestDto profileRequestDto) {
        return ResponseEntity.ok(profileService.updateProfile(u_id, p_id, profileRequestDto));
    }
    @PutMapping("/{userId}/profiles/{profileId}/image")
    public ResponseEntity<Optional<ProfileResponseDto>> updateProfileImage(@PathVariable("userId") UUID u_id, @PathVariable("profileId") UUID p_id, @Valid @RequestBody ProfileImageRequestDto profileImageRequestDto) {
        return ResponseEntity.ok(profileService.updateProfileImage(u_id, p_id, profileImageRequestDto));
    }
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllUsers() {
        userService.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable UUID id) {
        Optional<UserResponseDto> user = userService.getById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
