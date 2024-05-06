package org.unitiva.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.unitiva.bean.Commento;
import org.unitiva.dto.CommentoDTO;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CommentoRepository implements PanacheRepositoryBase<Commento,Long> {

    @Inject
    UtenteRepository utenteRepository;

    @Inject
    PostRepository postRepository;

    public void save (CommentoDTO commentoDTO){
        try{
            Commento commento = new Commento();
            commento.setCorpo(commentoDTO.getCorpo());
            commento.setPost(postRepository.retrievePostById(commentoDTO.getIdpost()));
            commento.setUtente(utenteRepository.retrieveUtenteById(commentoDTO.getIdutente()));
            persist(commento);
        } catch (Exception e){
            throw new Error(e.getMessage());
        }
    }
    
    public void updateCommento (CommentoDTO commentoDTO ){
        try{
            Commento commento = findById(commentoDTO.getIdcommento());
            commento.setCorpo(commentoDTO.getCorpo());
            persist(commento);
            
        } catch (Exception e){
            throw new Error(e.getMessage());
        }
    }
    
        public Commento findById (Long id){
            return findById(id);
        }
    
        public void deleteCommento(Long id){
            try{
                deleteById(id);
            } catch (Exception e){
                throw new Error(e.getMessage());
            }
        }
}
