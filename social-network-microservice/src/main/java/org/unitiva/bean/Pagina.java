package org.unitiva.bean;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pagina")
public class Pagina extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idpagina")
    private Long idpagina;
    
    @Column(name="nome")
    private String nome;

    @Column(name="descrizione")
    private String descrizione;

    // @ManyToOne
    // @JoinColumn(name="idutente")
    // private Utente utente;

    // @OneToMany(mappedBy="idpost")
    // private List<Post> post;

    public  Pagina (){}

    public Pagina(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    // public Utente getUtente() {
    //     return utente;
    // }

    // public void setUtente(Utente utente) {
    //     this.utente = utente;
    // }

    @Override
    public String toString() {
        return "Pagina [nome=" + nome + ", descrizione=" + descrizione + "]";
    }

    

}
