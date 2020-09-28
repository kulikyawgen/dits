/*
@author Andrei Gorevoi
*/
package com.repository.role;

import com.model.Role;

import java.util.List;

public interface RoleRepository {

    Role findRoleByName(String name);
    Role findRoleById(int id);
    List<Role> findAllRoles();
    Role addRole(String roleName);

}
