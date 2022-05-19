package com.ajsw.java.payment.service.models.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(name = "id_person", foreignKey = @ForeignKey(name = "fk_client_person"))
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "client")
public class Client extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id_reserve"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserve> reserves;

    public Client(String firstName, String lastName, String phone, Account account, Address address) {
        super(firstName, lastName, phone, address, account);
    }

    public Client() {

    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }
}
