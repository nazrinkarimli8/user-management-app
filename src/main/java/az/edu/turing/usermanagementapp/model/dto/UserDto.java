package az.edu.turing.usermanagementapp.model.dto;

import az.edu.turing.usermanagementapp.domain.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private UUID id;
    private String name;
    private String surname;
    private Integer age;
    private String status; // enum
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ProfileEntity> profiles;
}
