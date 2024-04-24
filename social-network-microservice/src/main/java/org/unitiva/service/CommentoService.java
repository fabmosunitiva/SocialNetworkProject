package org.unitiva.service;

import org.unitiva.bean.Commento;
import org.unitiva.dto.CommentoDTO;
import org.unitiva.repository.CommentoRepository;
import org.unitiva.repository.PostRepository;
import org.unitiva.repository.UtenteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CommentoService {

    @Inject
    CommentoRepository commentoRepository;

    @Inject
    UtenteRepository utenteRepository;

    @Inject
    PostRepository postRepository;


    public void newCommento (CommentoDTO commentoDTO){        
        Commento commento = new Commento();
        commento.setCorpo(commentoDTO.getCorpo());
        commento.setPost(postRepository.retrievePostById(commentoDTO.getIdpost()));
        commento.setUtente(utenteRepository.retrieveUtenteById(commentoDTO.getIdutente()));
        commentoRepository.save(commento);
    }

}
