package com.yassine.test.springbootDemo.entity;

import jakarta.persistence.*;

@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleid;
    @Column(name = "role_name")
    private String rolename;

    public Role() {
    }

    public Role(String rolename) {
        this.rolename = rolename;
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
