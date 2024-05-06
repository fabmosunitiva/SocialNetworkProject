package org.unitiva.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="utente")
public class Utente extends PanacheEntityBase {

    @Id
    @Column(name="idutente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idutente;

    @Column(name="nome")
    private String nome;

    @Column(name="cognome")
    private String cognome;

    @Column(name="datanascita")
    private LocalDate datanascita;

    @ManyToOne
    @JoinColumn(name="idruolo")
    private Ruolo ruolo;


    public Utente (){}

    public Utente(String nome, String cognome, LocalDate datanascita, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.datanascita = datanascita;
        this.ruolo = ruolo;
    }

    public Long getIdutente() {
        return idutente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDatanascita() {
        return datanascita;
    }

    public void setDatanascita(LocalDate datanascita) {
        this.datanascita = datanascita;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }



    @Override
    public String toString() {
        return "Utente [idutente=" + idutente + ", nome=" + nome + ", cognome=" + cognome + ", datanascita="
                + datanascita + ", ruolo=" + ruolo + "]";
    }

    
    



}
