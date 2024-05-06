package org.unitiva.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

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
