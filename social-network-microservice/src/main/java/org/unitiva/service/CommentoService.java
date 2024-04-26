package org.unitiva.service;

import org.unitiva.bean.Commento;
import org.unitiva.dto.CommentoDTO;
import org.unitiva.repository.CommentoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CommentoService {

    @Inject
    CommentoRepository commentoRepository;


    public void newCommento (CommentoDTO commentoDTO){        
        commentoRepository.save(commentoDTO);
    }

    public Commento retrieveById (Long id){
        return commentoRepository.findById(id);

    }

    public void deleteById (Long id){
        commentoRepository.deleteCommento(id);
    }

    public void updateCommento (CommentoDTO commentoDTO){
        commentoRepository.updateCommento(commentoDTO);
    }

}
