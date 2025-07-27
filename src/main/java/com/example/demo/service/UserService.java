package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepositry;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

//    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepositry userRepositry;
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public Boolean saveNewUser(User user){
        boolean result=false;
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepositry.save(user);
            return true;
        }catch (Exception e){
            log.error("error aavi mara vala");
            log.warn("warning dav su sudhari ja");
            log.info("tane ak vat kav bhani le baka nakar nay bhegu thay");
            return result;
        }
    }

    public void saveUser(User user){
        userRepositry.save(user);
    }

    public void saveNewAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepositry.save(user);
    }



    public List<User> getAll(){
        return userRepositry.findAll();
    }


    public Optional<User> getEntryById(ObjectId myid){
        return userRepositry.findById(myid);
    }

    public void deleteById(ObjectId myid){
        userRepositry.deleteById(myid);
    }

    public User findByUserName(String userName){
        return userRepositry.findByUserName(userName);
    }


}
