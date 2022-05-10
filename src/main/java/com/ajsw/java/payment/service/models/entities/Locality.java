package com.ajsw.java.payment.service.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "locality")
public class Locality {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_locality")
    private int idLocality;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "postal_code")
    private String postalCode;

    public int getIdLocality() {
        return idLocality;
    }

    public void setIdLocality(int idLocality) {
        this.idLocality = idLocality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
