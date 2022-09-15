package com.xmen.api.controller.user;

import java.util.ArrayList;
import java.util.List;

import com.xmen.api.dto.ReturnDTO;
import com.xmen.api.entity.user.User;
import com.xmen.api.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping()
    public ReturnDTO findAll(@RequestParam(name = "nome",required = false) String nome){
        if(nome == null || nome.isEmpty()) return userService.findAll();
        else return userService.findByNome(nome);
        
    }
    @GetMapping("/login")
    public ReturnDTO login(@RequestParam(name = "nome") String nome, @RequestParam(name = "senha") String senha){
        return userService.loginFindOne(nome,senha);
    }
    @PutMapping("/{id}")
    public ReturnDTO updateUser(@RequestBody User user, @PathVariable String id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public ReturnDTO deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }
}
