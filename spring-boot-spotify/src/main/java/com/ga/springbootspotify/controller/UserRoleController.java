package com.ga.springbootspotify.controller;

import com.ga.springbootspotify.model.UserRole;
import com.ga.springbootspotify.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    UserRoleService roleService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{rolename}")
    public UserRole getRole(@PathVariable String rolename) {
        return roleService.getRole(rolename);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public UserRole createRole(@RequestBody UserRole role) {
        return roleService.createRole(role);
    }

}
