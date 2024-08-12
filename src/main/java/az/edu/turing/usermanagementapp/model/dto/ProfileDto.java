package az.edu.turing.usermanagementapp.model.dto;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private UUID id;
    private String nickname;
    private String password;
    private String email;
    private UserEntity user;
}
