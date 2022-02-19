package com.umb.movilguia1.business.controller;

import com.umb.movilguia1.model.dto.UserDto;
import com.umb.movilguia1.business.service.UserService;
import com.umb.movilguia1.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movil/guia1/v1/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
        if (userService.validateEmail(userDto.getEmail())!=null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
    }
}
