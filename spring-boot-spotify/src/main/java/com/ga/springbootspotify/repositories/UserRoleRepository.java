package com.ga.springbootspotify.repositories;

import com.ga.springbootspotify.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    public UserRole findByName(String name);
}
