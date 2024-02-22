package com.yassine.test.springbootDemo.entity.login;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleid;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 20)
    private ERole rolename;

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }


    public Role() {

    }

    public Long getRoleid() {
        return roleid;
    }

    public ERole getRolename() {
        return rolename;
    }

    public void setRolename(ERole rolename) {
        this.rolename = rolename;
    }
}
