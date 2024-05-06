package org.unitiva.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.unitiva.bean.Ruolo;
import org.unitiva.repository.RuoloRepository;

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
