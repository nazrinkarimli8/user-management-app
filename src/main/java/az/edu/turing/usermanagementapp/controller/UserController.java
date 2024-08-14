package az.edu.turing.usermanagementapp.controller;

import az.edu.turing.usermanagementapp.model.dto.request.ProfileRequestDto;
import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.ProfileResponseDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
import az.edu.turing.usermanagementapp.service.ProfileService;
import az.edu.turing.usermanagementapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
