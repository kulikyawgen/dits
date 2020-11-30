package com.service.user;

import com.model.User;
import com.repository.user.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserServiceImpTest {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserServiceImp userServiceImp;

    private static final int USER_ID = 1;
    private String userLogin = "userLogin";
    User user;
    List<User> users;

    @Before
    public void initUser() {
        MockitoAnnotations.openMocks(this);
        users = new ArrayList<>();
        user = new User();
        user.setFirstName("UserName");
        user.setLastName("Lastname");
        user.setLogin("userLogin");
        user.setPassword(userLogin);
        user.setUserId(USER_ID);
        Mockito.when(userRepo.findByLogin(userLogin)).thenReturn(user);
    }

    @Test
    public void should_return_User_after_findByLogin() {
        User fromService = userServiceImp.findByLogin(userLogin);
        assertEquals(user, fromService);
    }

}