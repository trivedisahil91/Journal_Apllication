package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@Tag(name="Public APIs")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    @Operation(summary="Create User")
    public Boolean createUser(@RequestBody User user){
        userService.saveNewUser(user);
        return true;
    }


}

