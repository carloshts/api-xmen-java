package com.xmen.api.controller.user;

import java.util.ArrayList;
import java.util.List;

import com.xmen.api.dto.ReturnDTO;
import com.xmen.api.entity.user.User;
import com.xmen.api.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestCtr {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ReturnDTO createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
