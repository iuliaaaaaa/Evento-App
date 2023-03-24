package evento.business.RESTforUsers;

import javax.transaction.Transactional;

public interface DeleteUserUseCase {

    @Transactional
    void deleteUserByEmail(String email);

    void deleteUser(long userId);
}
