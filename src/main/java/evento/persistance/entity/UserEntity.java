package evento.persistance.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Length(min = 2, max = 20)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column (name = "email")
    private String email;

    @NotBlank
    @Column (name = "password")
    private String password;

    @NotBlank
    @Column (name = "surname")
    private String surname;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "role")
//    private Set<RoleEntity> userRoles;

    @NotBlank
    @Column(name = "role")
    private String role;


}
