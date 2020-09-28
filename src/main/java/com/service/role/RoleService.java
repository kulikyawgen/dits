/*
@author Andrei Gorevoi
*/
package com.service.role;

import com.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);
    Role getRoleById(int id);
    List<Role> getAllRoles();
    Role addRole(String roleName);

}
