package az.edu.turing.usermanagementapp.controller;

import az.edu.turing.usermanagementapp.model.dto.request.UserRequestDto;
import az.edu.turing.usermanagementapp.model.dto.response.UserResponseDto;
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

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDto userDto) {
        userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody UserRequestDto userDto) {
        UserResponseDto updatedUser = userService.update(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }


}
