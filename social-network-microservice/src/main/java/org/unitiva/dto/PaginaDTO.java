package org.unitiva.dto;

public class PaginaDTO {

    private String nome;
    private String descrizione;
    private Long idutente;
    
    public PaginaDTO(String nome, String descrizione, Long idutente) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.idutente = idutente;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Long getIdutente() {
        return idutente;
    }

    @Override
    public String toString() {
        return "PaginaDTO [nome=" + nome + ", descrizione=" + descrizione + ", idutente=" + idutente + "]";
    }

    

}
