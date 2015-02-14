package com.rizki.mufrizal.belajar.oauth2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_user_role",
        indexes = {
                @Index(columnList = "role", name = "role")
        }
)
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idCustomerRole")
    private String idCustomerRole;

    @Column(name = "role", nullable = false, length = 10)
    private String role = "ADMIN";

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "email", nullable = false)
    private User user;

    public String getIdCustomerRole() {
        return idCustomerRole;
    }

    public void setIdCustomerRole(String idCustomerRole) {
        this.idCustomerRole = idCustomerRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
