package org.unitiva.service;

import org.unitiva.bean.Commento;
import org.unitiva.bean.Utente;
import org.unitiva.dto.CommentoDTO;
import org.unitiva.repository.CommentoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CommentoService {

    @Inject
    CommentoRepository commentoRepository;

    @Inject
    UtenteService utenteService;


    public void newCommento (CommentoDTO commentoDTO){        
        commentoRepository.save(commentoDTO);
    }

    public Commento retrieveById (Long id){
        return commentoRepository.findById(id);

    }

    public void deleteById (Long idCommento, Long idUtente){
        try{
            Commento commento = retrieveById(idCommento);
            Utente utente = utenteService.retrieveById(idUtente);
                if (utente.getRuolo().getDescrizione().equalsIgnoreCase("Amministratore") 
                    || utente.getRuolo().getDescrizione().equalsIgnoreCase("Moderatore") 
                    || commento.getUtente().getIdutente() == idUtente) {
                        commentoRepository.deleteCommento(idCommento);             
                } else  {
                    throw new Error("Utente non autorizzato");
                }
            } catch (Exception e){
                throw new Error(e.getMessage());
            }
    }

    public void updateCommento (CommentoDTO commentoDTO){
        try{
            Long idutenteRepository = commentoRepository.findById(commentoDTO.getIdcommento()).getUtente().getIdutente();
            if (commentoDTO.getIdutente() == idutenteRepository)
                commentoRepository.updateCommento(commentoDTO);
            else 
                throw new Error("Utente non autorizzato alla modifica del commento");
        } catch (Exception e){
            throw new Error(e.getMessage());
        }
        
    }

}
