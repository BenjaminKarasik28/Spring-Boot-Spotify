package com.ga.springbootspotify.service;

import com.ga.springbootspotify.model.UserRole;

public interface UserRoleService {

    public UserRole createRole(UserRole newRole);

    public UserRole getRole(String roleName);
}