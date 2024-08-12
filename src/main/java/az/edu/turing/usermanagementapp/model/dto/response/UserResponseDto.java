package az.edu.turing.usermanagementapp.model.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record UserResponseDto(
        UUID id,
        String name,
        String surname,
        Integer age,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<UUID> profiles
) {
}
