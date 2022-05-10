package com.ajsw.java.payment.service.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account")
    private int idAccount;

    @Basic
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "created_at", nullable = false, columnDefinition = "date DEFAULT 'now()'")
    private Date createdAt = new Date(System.currentTimeMillis());

    @Basic
    @Column(name = "updated_at")
    private Date updatedAt;

    @Basic
    @Column(name = "active")
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "id_role")
    private Role role;

    public Account(String email, String password, Boolean active, Role role) {
        this.email = email;
        this.password = password;
        this.createdAt = new Date(System.currentTimeMillis());
        this.active = active;
        this.role = role;
    }

    public Account(int idAccount) {
        this.idAccount = idAccount;
    }

    public Account() {

    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
