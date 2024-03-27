package com.example.lkmt.services;

import com.example.lkmt.entity.User;
import com.example.lkmt.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    public List<User> getAllUsers() {
        return employeeRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> optional = employeeRepository.findById(id);
        return optional.orElse(null);
    }

    public void addUser(User user) {
        employeeRepository.save(user);
    }

    public void updateUser(User user) {
        employeeRepository.save(user);
    }

    public void deleteUser(Long id){
        employeeRepository.deleteById(id);}
}
