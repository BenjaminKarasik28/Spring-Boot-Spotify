package com.ga.springbootspotify.model;

import com.ga.springbootspotify.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public UserRole() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "userRole",
            cascade = CascadeType.ALL)
    private List<User> users;

    public void setUsers(List<User> users){ this.users = users; }

    public List<User> getUsers(){ return users; }

}