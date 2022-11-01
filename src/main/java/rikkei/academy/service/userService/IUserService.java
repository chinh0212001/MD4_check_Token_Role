package rikkei.academy.service.userService;

import rikkei.academy.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existByUsername(String username);
    Boolean existByEmail(String email);
    Optional<User>findByUsername(String username);
    User save(User user);

}
