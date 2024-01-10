package com.yassine.test.springbootDemo.entity;

import jakarta.persistence.*;

@Entity(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userid;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="active")
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public User(String username, String email, String password, boolean active, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public Long userid() {
        return userid;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean active() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role role() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
