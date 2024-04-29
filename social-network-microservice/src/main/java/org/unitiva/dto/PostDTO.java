package org.unitiva.dto;

public class PostDTO {

    private Long idPost;
    private String titolo;
    private String corpo;
    private Long idPagina;
    private Long idUtente;

    public PostDTO() {}

    public PostDTO(Long idPost, String titolo, String corpo, Long idPagina, Long idUtente) {
        this.idPost = idPost;
        this.titolo = titolo;
        this.corpo = corpo;
        this.idPagina = idPagina;
        this.idUtente = idUtente;
    }

    public PostDTO(String titolo, String corpo, Long idPagina, Long idUtente) {
        this.titolo = titolo;
        this.corpo = corpo;
        this.idPagina = idPagina;
        this.idUtente = idUtente;
    }

    public PostDTO(String titolo, String corpo, Long idUtente) {
        this.titolo = titolo;
        this.corpo = corpo;
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

    public Long getIdPost() {
        return idPost;
    }

    @Override
    public String toString() {
        return "PostDTO [titolo=" + titolo + ", corpo=" + corpo + ", idPagina=" + idPagina + ", idUtente=" + idUtente
                + "]";
    }

}
