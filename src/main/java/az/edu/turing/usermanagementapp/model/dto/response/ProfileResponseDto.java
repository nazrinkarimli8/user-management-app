package az.edu.turing.usermanagementapp.model.dto.response;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;

import java.util.UUID;

public record ProfileResponseDto(
        UUID id,
        String nickname,
        String password,
        String email,
        UserEntity user
) {
}
