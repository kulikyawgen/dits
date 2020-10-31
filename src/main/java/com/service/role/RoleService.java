package com.service.role;

import com.model.Role;
import com.model.User;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    void delete(Role role);

    void updateRole(Role role);

    List<Role> getAllRole();


    Role findByName(String s);
}
