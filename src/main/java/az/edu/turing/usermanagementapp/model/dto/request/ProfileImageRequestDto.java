package az.edu.turing.usermanagementapp.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProfileImageRequestDto(
        @NotBlank
        String userImage
) {
}
