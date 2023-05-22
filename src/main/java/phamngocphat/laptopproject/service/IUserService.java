package phamngocphat.laptopproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import phamngocphat.laptopproject.dto.UserRegisterDTO;
import phamngocphat.laptopproject.entity.UserEntity;

public interface IUserService extends UserDetailsService {
    UserEntity createUser(UserRegisterDTO userRegisterDTO);
}
