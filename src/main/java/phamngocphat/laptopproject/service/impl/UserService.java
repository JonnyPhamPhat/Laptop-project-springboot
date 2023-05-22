package phamngocphat.laptopproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import phamngocphat.laptopproject.converter.UserConverter;
import phamngocphat.laptopproject.dto.UserRegisterDTO;
import phamngocphat.laptopproject.entity.RoleEntity;
import phamngocphat.laptopproject.entity.UserEntity;
import phamngocphat.laptopproject.repository.UserRepository;
import phamngocphat.laptopproject.service.IUserService;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserEntity createUser(UserRegisterDTO userRegisterDTO) {
        UserEntity userEntity = new UserEntity(userRegisterDTO.getUsername(),
                passwordEncoder.encode(userRegisterDTO.getPassword()), userRegisterDTO.getFullName(),
                userRegisterDTO.getStatus(), Arrays.asList(new RoleEntity("ROLE_USER")));
        return userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("User or password invalid");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), mapearAutoridadesRoles(userEntity.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RoleEntity> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
