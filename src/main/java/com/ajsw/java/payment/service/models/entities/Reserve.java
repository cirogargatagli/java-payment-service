package com.ajsw.java.payment.service.models.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reserve")
public class Reserve {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reserve")
    private int idReserve;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(
            name = "id_course",
            referencedColumnName = "id_course",
            foreignKey = @ForeignKey(
                    name = "fk_reserve_course",
                    foreignKeyDefinition = "FOREIGN KEY (id_course)\n" +
                            "        REFERENCES course (id_course) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Course course;

    @ManyToOne
    @JoinColumn(
            name = "id_client",
            referencedColumnName = "id_person",
            foreignKey = @ForeignKey(
                    name = "fk_reserve_client",
                    foreignKeyDefinition = "FOREIGN KEY (id_client)\n" +
                            "        REFERENCES client (id_person) MATCH SIMPLE\n" +
                            "        ON UPDATE CASCADE\n" +
                            "        ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Client client;

    @OneToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;

    public int getIdReserve() {
        return idReserve;
    }

    public void setIdReserve(int idReserve) {
        this.idReserve = idReserve;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
