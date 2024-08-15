package az.edu.turing.usermanagementapp.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nickname;
    private String password;
    private String email;
    @Lob
    private String profilePhoto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
