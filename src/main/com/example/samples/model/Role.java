/*
 * Aleksander Spyra for Software Development Academy, Wroclaw 2018
 */

package com.example.samples.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "rolename")
    private String roleName;

    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public Role(String name) {
        this.roleName = name;
    }
}
