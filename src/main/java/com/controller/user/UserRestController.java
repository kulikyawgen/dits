/*
@author Andrei Gorevoi
*/
package com.controller.user;

import com.controller.BaseController;
import com.model.User;
import com.service.role.RoleService;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("registration")
public class UserRestController extends BaseController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping(value = "/")
    public User addUser(@RequestBody User newUser){
        if(userService.findByLogin(newUser.getLogin())==null){
            newUser.setRoles(Arrays.asList(roleService.findByName("USER")));
            return userService.addUser(newUser);
        }
        return null;
    }


}
