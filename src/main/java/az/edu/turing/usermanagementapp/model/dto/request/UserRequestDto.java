package az.edu.turing.usermanagementapp.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDto(

        @NotBlank
        String name,

        @NotBlank
        String surname,

        @NotBlank
        int age

) {
}
