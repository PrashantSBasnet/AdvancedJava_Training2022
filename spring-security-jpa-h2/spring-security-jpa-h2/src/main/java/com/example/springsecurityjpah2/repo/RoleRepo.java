package com.example.springsecurityjpah2.repo;


import com.example.springsecurityjpah2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
