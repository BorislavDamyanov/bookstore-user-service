package boris.userservice.service.interfaces;

import boris.userservice.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    List<User> getUserList();
    Optional<User> getUser(Long id);
    User addUser(User user);
    void deleteUserById(Long id);



}
