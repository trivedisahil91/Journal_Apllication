package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepositry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepositry userRepositry; // aa null hoy atle aapade @BeforeEach annotion ni madad thi mocks ne insilize kari didha
    @Disabled
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    //@MockBean ni madad thi UserDetailsServiceImpl class ma inject karel UserRepositry class ni badale aapado aa dumy UserRepositry replace thay jase
//    @MockBean
//    private UserRepositry userRepositry;

    @Disabled
    @Test
    void loadUserByUsernameTest(){
        when(userRepositry.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("sahil").password("sahil").roles(new ArrayList<>()).build());
        UserDetails user=userDetailsServiceImpl.loadUserByUsername("sahil");
        Assertions.assertNotNull(user);
    }




}
