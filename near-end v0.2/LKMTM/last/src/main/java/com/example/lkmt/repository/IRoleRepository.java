package com.example.lkmt.repository;

import com.example.lkmt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
