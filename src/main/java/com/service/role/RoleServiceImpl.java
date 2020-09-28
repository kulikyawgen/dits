/*
@author Andrei Gorevoi
*/
package com.service.role;

import com.model.Role;
import com.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.findRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAllRoles();
    }

    @Override
    public Role addRole(String roleName) {
        return roleRepository.addRole(roleName);
    }
}
