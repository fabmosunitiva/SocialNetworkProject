package org.unitiva.dto;

public class PostDTO {

    private String titolo;
    private String corpo;
    private Long idPagina;
    private Long idUtente;

    public PostDTO(String titolo, String corpo, Long idPagina, Long idUtente) {
        this.titolo = titolo;
        this.corpo = corpo;
        this.idPagina = idPagina;
        this.idUtente = idUtente;
    }
    public String getTitolo() {
        return titolo;
    }
    public String getCorpo() {
        return corpo;
    }
    public Long getIdPagina() {
        return idPagina;
    }
    public Long getIdUtente() {
        return idUtente;
    }

    @Override
    public String toString() {
        return "PostDTO [titolo=" + titolo + ", corpo=" + corpo + ", idPagina=" + idPagina + ", idUtente=" + idUtente
                + "]";
    }

}
