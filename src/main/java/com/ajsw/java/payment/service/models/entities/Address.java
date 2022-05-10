package com.ajsw.java.payment.service.models.entities;

import javax.persistence.*;

@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_address")
    private int idAddress;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "number_house")
    private String numberHouse;

    @OneToOne
    @JoinColumn(name = "id_locality")
    private Locality locality;

    public Address(int idAddress) {
        this.idAddress = idAddress;
    }

    public Address() {

    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }
}
