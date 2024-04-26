package org.unitiva.service;

import java.time.LocalDate;

import org.unitiva.bean.Ruolo;
import org.unitiva.bean.Utente;
import org.unitiva.dto.UtenteDTO;
import org.unitiva.repository.RuoloRepository;
import org.unitiva.repository.UtenteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UtenteService {

    @Inject
    UtenteRepository utenteRepository;

    @Inject
    RuoloRepository ruoloRepository;

    public void addUtente(UtenteDTO utenteDto){
        try {
            Utente utente = new Utente();
            utente = createUtenteFromDto(utente, utenteDto);
            utenteRepository.createUtente(utente);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    
    public void updateUtente(Long id, UtenteDTO utenteDto){
        try {
            Utente utente = utenteRepository.retrieveUtenteById(id);
            utente = createUtenteFromDto(utente, utenteDto);
            utenteRepository.createUtente(utente);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Utente retrieveById (Long id){
        return utenteRepository.findById(id);
    }

    public void deleteById (Long id){
        utenteRepository.deleteById(id);
    }

    private Utente createUtenteFromDto(Utente utente, UtenteDTO utenteDto){
        String nome = utenteDto.getNome();
        String cognome = utenteDto.getCognome();
        LocalDate dataDiNascita = utenteDto.getDatanascita();
        Long idRuolo = utenteDto.getRuolo();
        Ruolo ruolo = ruoloRepository.findById(idRuolo);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setDatanascita(dataDiNascita);
        utente.setRuolo(ruolo);
        return utente;
    }
}
