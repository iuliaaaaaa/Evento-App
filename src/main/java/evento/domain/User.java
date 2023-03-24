package evento.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String userType;

    public User(long id, String email, String password, String name, String surname, String userType){
        this.id = id;
        this.name = name;
        this. email = email;
        this.password = password;
        this.surname = surname;
        this.userType = userType;
    }


}
