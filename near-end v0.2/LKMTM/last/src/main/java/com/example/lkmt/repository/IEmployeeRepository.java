package com.example.lkmt.repository;

import com.example.lkmt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<User, Long> {

}
