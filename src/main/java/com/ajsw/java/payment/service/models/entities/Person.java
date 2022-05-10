package com.ajsw.java.payment.service.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_person")
    protected int idPerson;
    @Basic
    @Column(name = "first_name", nullable = false)
    protected String firstName;
    @Basic
    @Column(name = "last_name", nullable = false)
    protected String lastName;

    @Basic
    @Column(name = "phone", unique = true)
    protected String phone;

    @OneToOne
    @JoinColumn(name = "id_account")
    protected Account account;

    public Person(String firstName, String lastName, String phone, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.account = account;
    }

    public Person() {

    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
