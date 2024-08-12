package az.edu.turing.usermanagementapp.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record UserAndProfileResponseDto(
        UUID id,
        String name,
        String surname,
        Integer age,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<ProfileResponseDto> profiles
) {
}
