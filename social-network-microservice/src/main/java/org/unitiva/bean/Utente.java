package org.unitiva.bean;

import java.time.LocalDate;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="utente")
public class Utente extends PanacheEntityBase {

    @Id
    @Column(name="idutente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idutente;

    @Column(name="idfollower")
    private Long idfollower;

    @Column(name="nome")
    private String nome;

    @Column(name="cognome")
    private String cognome;

    @Column(name="datanascita")
    private LocalDate datanascita;

    @OneToOne
    @JoinColumn(name="idruolo")
    private Ruolo ruolo;

    //  @ManyToMany(mappedBy = "idpost")
    //  private List<Post> post;

    // @ManyToMany(mappedBy = "idfollower")
    // private List<Post> idpost_follower;

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

    public void setIdutente(Long idutente) {
        this.idutente = idutente;
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
