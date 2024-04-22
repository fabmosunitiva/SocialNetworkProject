package org.unitiva.bean;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ruolo")
public class Ruolo extends PanacheEntityBase {

    @Id
    @Column(name="idruolo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idruolo;

    @Column(name="descrizione")
    private String descrizione;

    public Ruolo (){}

    public Ruolo(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getId() {
        return idruolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Ruolo [descrizione=" + descrizione + "]";
    }

    
}
