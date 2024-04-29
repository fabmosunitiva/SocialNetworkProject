package org.unitiva.service;

import java.time.LocalDate;

import org.unitiva.bean.Ruolo;
import org.unitiva.bean.Utente;
import org.unitiva.dto.UtenteDTO;
import org.unitiva.exception.NotFoundException;
import org.unitiva.exception.database.DataAccessException;
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

    public void addUtente(UtenteDTO utenteDto) throws DataAccessException,NullPointerException{
            Utente utente = new Utente();
            utente = createUtenteFromDto(utente, utenteDto);
            utenteRepository.createUtente(utente);
    }

    
    public void updateUtente(Long id, UtenteDTO utenteDto) throws DataAccessException,NotFoundException,NullPointerException{
            Utente utente = utenteRepository.retrieveUtenteById(id);
            utente = createUtenteFromDto(utente, utenteDto);
            utenteRepository.createUtente(utente);
    }

    public Utente retrieveById (Long id) throws NotFoundException,DataAccessException{

        try {
            Utente utente = utenteRepository.retrieveUtenteById(id);
            if(utente == null){
                throw new NotFoundException(id,"Utente non trovato");
            }
            return utente;
        } catch (DataAccessException e) {
            throw new DataAccessException(e.getMessage(), e.getCause());
        }
    }

    public void deleteById (Long id) throws NotFoundException,DataAccessException{
        try {
            utenteRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e.getCause());
        }
    }

    private Utente createUtenteFromDto(Utente utente, UtenteDTO utenteDto) throws NullPointerException{
        String nome = utenteDto.getNome();
        String cognome = utenteDto.getCognome();
        LocalDate dataDiNascita = utenteDto.getDatanascita();
        Long idRuolo = utenteDto.getRuolo();
        Ruolo ruolo = ruoloRepository.retrieveRuoloById(idRuolo);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setDatanascita(dataDiNascita);
        utente.setRuolo(ruolo);
        return utente;
    }
}
