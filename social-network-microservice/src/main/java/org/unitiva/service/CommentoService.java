package org.unitiva.service;

import org.unitiva.bean.Commento;
import org.unitiva.repository.CommentoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CommentoService {

    @Inject
    CommentoRepository commentoRepository;

    public void save (Commento commento){
        commentoRepository.persist(commento);
    }

    public Commento findById (Long id){
        return commentoRepository.findById(id);
    }

    public void deleteById (Long id){
        commentoRepository.deleteById(id);
    }

}
