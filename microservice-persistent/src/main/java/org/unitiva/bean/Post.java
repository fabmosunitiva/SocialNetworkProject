package org.unitiva.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name="post")
public class Post extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="idpost")
    private Long idpost;

    @Column(name="titolo")
    private String titolo;
    
    @Column(name="corpo")
    private String corpo;


    @ManyToOne
    @JoinColumn(name = "idutente")
    private Utente utente;

    @ManyToMany
    @JoinTable(name = "like_post",
        joinColumns = @JoinColumn(name = "idpost"),
        inverseJoinColumns = @JoinColumn(name = "idutente"))
    private HashSet<Utente> like;

    public Post (){}

 

    public Post(String titolo, String corpo, Set<Pagina> pagina, Utente utente, HashSet<Utente> like) {
        this.titolo = titolo;
        this.corpo = corpo;
      
        this.utente = utente;
        this.like = like;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }



    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public HashSet<Utente> getLike() {
        return like;
    }

    public void setLike(HashSet<Utente> like) {
        this.like = like;
    }



    @Override
    public String toString() {
        return "Post [titolo=" + titolo + ", corpo=" + corpo + ", utente=" + utente + ", like="
                + like + "]";
    }




}
