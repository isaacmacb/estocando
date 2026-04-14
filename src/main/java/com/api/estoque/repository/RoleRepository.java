package com.api.estoque.repository;

import com.api.estoque.entity.Role;
import com.api.estoque.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);


}
