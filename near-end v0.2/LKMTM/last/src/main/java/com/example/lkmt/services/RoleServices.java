package com.example.lkmt.services;

import com.example.lkmt.repository.IRoleRepository;
import com.example.lkmt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServices {
    @Autowired
    private IRoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        } else {
            throw new RuntimeException("Role not found");
        }
    }
}
