package phamngocphat.laptopproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import phamngocphat.laptopproject.dto.UserRegisterDTO;
import phamngocphat.laptopproject.entity.UserEntity;

@Component
public class UserConverter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserRegisterDTO toDTO(UserEntity userEntity){
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setId(userEntity.getId());
        userRegisterDTO.setFullName(userEntity.getFullName());
        userRegisterDTO.setUsername(userEntity.getUsername());
        passwordEncoder.encode(userEntity.getPassword());
        userRegisterDTO.setStatus(userEntity.getStatus());
        return userRegisterDTO;
    }

    public UserEntity toEntity(UserEntity userEntity, UserRegisterDTO userRegisterDTO){
        userEntity.setId(userRegisterDTO.getId());
        userEntity.setFullName(userRegisterDTO.getFullName());
        userEntity.setUsername(userRegisterDTO.getUsername());
        passwordEncoder.encode(userRegisterDTO.getPassword());
        userEntity.setStatus(userRegisterDTO.getStatus());
        return userEntity;
    }
}
