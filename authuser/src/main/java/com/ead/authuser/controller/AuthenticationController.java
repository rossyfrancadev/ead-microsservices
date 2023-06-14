package com.ead.authuser.controller;

import com.ead.authuser.dto.UserDto;
import com.ead.authuser.entity.UserEntity;
import com.ead.authuser.enums.UserStatus;
import com.ead.authuser.enums.UserType;
import com.ead.authuser.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/auth")
@RestController
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody UserDto userDto){
        if(userService.existByUserName(userDto.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is Already taken!");
        }
        if(userService.existByEmail(userDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Email is Already taken!");
        }

        var userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userEntity.setUserStatus(UserStatus.ACTIVE);
        userEntity.setUserType(UserType.STUDENT);
        userEntity.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        userEntity.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTF")));
        userService.save(userEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);

    }
}
