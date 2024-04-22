package org.unitiva.service;

import org.unitiva.bean.Utente;
import org.unitiva.repository.UtenteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UtenteService {

    @Inject
    UtenteRepository utenteRepository;

    public void save (Utente utente){
      utenteRepository.persist(utente);  
    }

    public Utente findById (Long id){
        return utenteRepository.findById(id);
    }

    public void deleteById (Long id){
        utenteRepository.deleteById(id);
    }
}
