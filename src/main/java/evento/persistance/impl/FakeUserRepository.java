package evento.persistance.impl;

//import evento.domain.UserType;
//import evento.persistance.UserRepository;
//import evento.persistance.entity.UserEntity;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class FakeUserRepository implements UserRepository {
//
//    private static long NEXT_ID = 1;
//    private final List<UserEntity> savedUsers;
//
//    public FakeUserRepository() { this.savedUsers = new ArrayList<>();}
//    @Override
//    public boolean existsById(long id) {
//        return this.savedUsers
//                .stream()
//                .anyMatch(userEntity -> userEntity.getId().equals(id));
//
//    }
//
//    @Override
//    public List<UserEntity> findAllByUserType(UserType userType) {
//        return this.savedUsers
//                .stream()
//                .filter(userEntity -> userEntity.getUserType().equals(userType)).toList();
//    }
//
//    @Override
//    public UserEntity save(UserEntity user) {
//        if(user.getId()== null){
//            user.setId(NEXT_ID);
//            NEXT_ID++;
//            this.savedUsers.add(user);
//        }
//        return user;
//    }
//
//    @Override
//    public void deleteByName(String name) {
//        this.savedUsers.removeIf(userEntity -> userEntity.getName().equals(name));
//    }
//
//    @Override
//    public List<UserEntity> findAll() {
//        return Collections.unmodifiableList(this.savedUsers);
//    }
//
//    @Override
//    public Optional<UserEntity> findById(long id) {
//        return this.savedUsers.stream()
//                .filter(userEntity -> userEntity.getId().equals(id))
//                .findFirst();
//    }
//}
