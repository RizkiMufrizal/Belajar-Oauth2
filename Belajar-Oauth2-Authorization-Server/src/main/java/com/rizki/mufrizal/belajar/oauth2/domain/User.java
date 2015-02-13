package com.rizki.mufrizal.belajar.oauth2.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user",
        indexes = {
                @Index(columnList = "username", name = "username")
        }
)
public class User implements Serializable {

    @Id
    @Column(name = "username", length = 30, unique = true)
    private String username;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "enable", columnDefinition = "TINYINT")
    private Boolean enable = true;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = javax.persistence.CascadeType.ALL)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<UserRole> userRoles = new HashSet<UserRole>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
