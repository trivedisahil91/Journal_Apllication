package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepositry;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;


@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private UserService userService;



    @Disabled
    @Test
    public void testFindByUserName(){
        Assertions.assertEquals(4,2+2); //asert atale davo kar vo have aaya assertEquals atale parameter ma didhi value a same hovi joye jema pelo argument a expected output chhe ane bija peramiter ma je method chhe anu actual output chhe to davo sacho chhe ke nay te cheak thay chhe
        Assertions.assertNotNull(userRepositry.findByUserName("om"));
    }


    @Disabled
    @ParameterizedTest
    @ValueSource(strings={
            "sahil",
            "om"
    })
    public void testFindByUserNameByLooping(String name){
        Assertions.assertEquals(4,2+2); //asert atale davo kar vo have aaya assertEquals atale parameter ma didhi value a same hovi joye jema pelo argument a expected output chhe ane bija peramiter ma je method chhe anu actual output chhe to davo sacho chhe ke nay te cheak thay chhe
        Assertions.assertNotNull(userRepositry.findByUserName(name));
    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testFindByUserNameByArgumentSource(User user){
        Assertions.assertTrue(userService.saveNewUser(user));

    }


    @Disabled
    @BeforeEach
    void setUp(){

    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,4"
    })
    public void testvialoop(int a,int b,int expectrd){
        Assertions.assertEquals(expectrd,a+b);
    }



}
