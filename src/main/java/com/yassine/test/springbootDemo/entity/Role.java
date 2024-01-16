package com.yassine.test.springbootDemo.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleid;
    @Column(name = "role_name")
    private String rolename;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String rolename, Set<User> users) {
        this.rolename = rolename;
        this.users = users;
    }

    public Role() {

    }

    public Long roleid() {
        return roleid;
    }

    public String rolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
