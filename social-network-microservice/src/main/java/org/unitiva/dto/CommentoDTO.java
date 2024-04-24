package org.unitiva.dto;

public class CommentoDTO {

    private Long idcommento;
    private String corpo;
    private Long idutente;
    private Long idpost;

    public CommentoDTO (String corpo,Long idutente,Long idpost){
        this.corpo=corpo;
        this.idutente=idutente;
        this.idpost=idpost;
    }


    public Long getIdcommento() {
        return idcommento;
    }
    public String getCorpo() {
        return corpo;
    }
    public Long getIdutente() {
        return idutente;
    }
    public Long getIdpost() {
        return idpost;
    }

    

}
