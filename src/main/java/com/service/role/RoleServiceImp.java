package com.service.role;

import com.model.Role;
import com.repository.role.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void addRole(Role role) {
    roleRepo.save(role);
    }

    @Override
    public void delete(Role role) {
roleRepo.delete(role);
    }

    @Override
    public void updateRole(Role role) {
roleRepo.saveAndFlush(role);
    }

    @Override
    public List<Role> getAllRole() {
         List<Role> all = roleRepo.findAll();
        return all;
    }

    @Override
    public Role findByName(String s) {
        return roleRepo.findByName(s);
    }

}
