package com.example.lkmt.services;

import com.example.lkmt.repository.IUserRepository;
import com.example.lkmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServices {
    @Autowired
    private IUserRepository userRepository;

    public long countAdminUsers() {
        return userRepository.countAdminUsers();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}