package com.example.springsecurityjpah2.repo;

import com.example.springsecurityjpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
