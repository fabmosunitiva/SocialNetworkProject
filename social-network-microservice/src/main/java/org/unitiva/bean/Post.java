package org.unitiva.bean;

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

    // @ManyToMany
    // @JoinTable(name = "pagina_post",
    //     joinColumns =  @JoinColumn (name="id_pagina"), inverseJoinColumns = @JoinColumn(name="id_post"))
    // private Set<Pagina> pagina;

    public Post (){}

    public Post(String titolo, String corpo) {
        this.titolo = titolo;
        this.corpo = corpo;
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

    @Override
    public String toString() {
        return "Post [titolo=" + titolo + ", corpo=" + corpo + " ]";
    }
    


}
