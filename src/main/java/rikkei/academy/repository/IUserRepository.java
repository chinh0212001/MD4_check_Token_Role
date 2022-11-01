package rikkei.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rikkei.academy.model.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);//Check username không trùng lặp
    Boolean existsByEmail(String email);//Check email không trùng lặp
    Optional<User> findByUsername(String username); //Tìm kiếm username có tồn tại trong DB không?
}
