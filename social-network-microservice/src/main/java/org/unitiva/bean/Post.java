package org.unitiva.bean;

import java.util.HashSet;
import java.util.Set;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="post")
public class Post extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idpost")
    private Long idpost;

    @Column(name="titolo")
    private String titolo;
    
    @Column(name="corpo")
    private String corpo;

    @ManyToMany
    @JoinTable(name = "pagina_post",
        joinColumns =  @JoinColumn (name="id_pagina"), inverseJoinColumns = @JoinColumn(name="id_post"))
    private Set<Pagina> pagina;

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
        this.pagina = pagina;
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

    public Set<Pagina> getPagina() {
        return pagina;
    }

    public void setPagina(Set<Pagina> pagina) {
        this.pagina = pagina;
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
        return "Post [titolo=" + titolo + ", corpo=" + corpo + ", pagina=" + pagina + ", utente=" + utente + ", like="
                + like + "]";
    }




}
