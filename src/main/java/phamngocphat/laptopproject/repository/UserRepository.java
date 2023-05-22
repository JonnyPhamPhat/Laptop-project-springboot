package phamngocphat.laptopproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phamngocphat.laptopproject.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
