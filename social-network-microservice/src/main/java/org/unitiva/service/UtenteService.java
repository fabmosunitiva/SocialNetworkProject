package org.unitiva.service;

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
            Utente utente = createUtente(utenteDto);
            utenteRepository.createUtente(utente);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    
    public void updateUtente(UtenteDTO utenteDto){
        try {
            Utente utente = createUtente(utenteDto);
            utenteRepository.updateUtente(utente);
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

    private Utente createUtente(UtenteDTO utenteDto){
        Utente utente = new Utente();
        utente.setNome(utenteDto.getNome());
        utente.setCognome(utenteDto.getCognome());
        utente.setDatanascita(utenteDto.getDatanascita());
        Long idRuolo = utenteDto.getRuolo();
        Ruolo ruolo = ruoloRepository.retrieveRuoloById(idRuolo);
        utente.setRuolo(ruolo); 
        return utente;
    }
}
