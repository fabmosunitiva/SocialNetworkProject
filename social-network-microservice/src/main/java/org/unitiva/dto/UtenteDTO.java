package org.unitiva.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;

public class UtenteDTO {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cognome;
    @NotEmpty
    private LocalDate datanascita;
    @NotEmpty
    private Long ruolo;

    public UtenteDTO() {
    }

    public UtenteDTO(String nome, String cognome, LocalDate datanascita, Long ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.datanascita = datanascita;
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public LocalDate getDatanascita() {
        return datanascita;
    }
    public Long getRuolo() {
        return ruolo;
    }

}
