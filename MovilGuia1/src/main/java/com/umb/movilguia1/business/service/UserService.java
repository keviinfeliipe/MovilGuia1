package com.umb.movilguia1.business.service;

import com.umb.movilguia1.model.dto.UserDto;
import com.umb.movilguia1.model.entity.User;
import com.umb.movilguia1.model.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDto userDto){
        User user = new User(
                userDto.getFullName(),
                userDto.getEmail(),
                userDto.getPassword());
        userRepository.save(user);
        return user;
    }

    public User validateEmail(String email){
        return userRepository.getByEmail(email).orElse(null);
    }
}
