package org.unitiva.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commento")
public class Commento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idcommento")
    private Long idcommento;

    @Column(name="corpo")
    private String corpo;

    @ManyToOne
    @JoinColumn(name = "idutente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "idpost")
    private Post post;

    public Commento (){}

    public Commento(String corpo) {
        this.corpo = corpo;
    }

    public Long getIdcommento() {
        return idcommento;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    @Override
    public String toString() {
        return "Commento [corpo=" + corpo + ", utente=" + utente + ", post=" + post + "]";
    }



    

}
