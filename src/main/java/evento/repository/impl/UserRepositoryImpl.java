package evento.repository.impl;

import evento.persistance.converters.UserConverter;
import evento.domain.User;
import evento.persistance.converters.UserToEntityConverter;
import evento.persistance.entity.UserEntity;
import evento.repository.UserRepository;
import evento.repository.JPA.UserRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private UserRepositoryJPA userRepositoryJPA;

    @Override
    public User login(String email, String password) {
        UserEntity user = userRepositoryJPA.findByEmail(email);

        return UserConverter.convert(user);
    }

    @Override
    public User create (User user){
        UserEntity userEntity = UserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .password(user.getPassword())
                .role(user.getUserType())
                .build();

                return UserConverter.convert((userRepositoryJPA.save(userEntity)));
    }

    @Override
    public List<User> findAllByRole(String role) {
        return userRepositoryJPA.findAllByRole(role)
                .stream()
                .map(UserConverter::convert)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(UserConverter.convert(userRepositoryJPA.findById(id).get()));
    }

    @Override
    public Boolean existsBySurname(String surname) {
        return userRepositoryJPA.findBySurname(surname);
    }

    @Override
    public List<User> findAll() {
        return userRepositoryJPA.findAll()
                .stream()
                .map(UserConverter::convert)
                .toList();
    }

    @Override
    public void deleteById(long userId) {
         userRepositoryJPA.deleteById(userId);
    }

    @Override
    public void deleteByEmail(String email) {
         userRepositoryJPA.deleteByEmail(email);
    }


}
