package org.unitiva.service;

import org.unitiva.bean.Ruolo;
import org.unitiva.repository.RuoloRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RuoloService {

    @Inject
    RuoloRepository ruoloRepository;

    public void save (Ruolo ruolo){
        ruoloRepository.persist(ruolo);
    }

    public Ruolo findRuoloById (Long id){
        return ruoloRepository.findById(id);
    }

    public void deleteById (Long id){
        ruoloRepository.deleteById(id);
    }

    

}
