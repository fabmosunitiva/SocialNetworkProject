package org.unitiva.service;

import org.unitiva.bean.Post;
import org.unitiva.bean.Ruolo;
import org.unitiva.bean.Utente;
import org.unitiva.dto.PostDTO;
import org.unitiva.exception.NotFoundException;
import org.unitiva.exception.UserNotAllowed;
import org.unitiva.exception.database.DataAccessException;
import org.unitiva.repository.PostRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostService {

    @Inject
    PostRepository postRepository;

    @Inject
    UtenteService utenteService;

    public void save (PostDTO postDTO) throws DataAccessException{
        postRepository.createPost(postDTO);
    }

    public void updatePost (PostDTO postDTO) throws DataAccessException{
        try{
            Long idutenteRepository = postRepository.findById(postDTO.getIdPost()).getUtente().getIdutente();
            Utente utente = utenteService.retrieveById(postDTO.getIdUtente());
            if (postDTO.getIdUtente() == idutenteRepository)
                postRepository.updatePost(postDTO);
            else 
            throw new UserNotAllowed(idutenteRepository,utente.getRuolo().getDescrizione());
        } catch (Exception e){
            throw new Error(e.getMessage());
        }
    }

    public Post retrieveById (Long id) throws DataAccessException{
        Post post= postRepository.retrievePostById(id);
        if(post == null){
            throw new NotFoundException(id,"Post non Trovato");
        }
        return post;
    }

    public void deleteById (Long idPost, Long idUtente) throws DataAccessException,NotFoundException{
            Post post = retrieveById(idPost);
            Utente autorePost = post.getUtente();
            Utente utente = utenteService.retrieveById(idUtente);
            Ruolo ruoloUtente = utente.getRuolo();
            if (hadPrivileges(ruoloUtente) || autorePost.equals(utente)) {
                postRepository.deletePost(idPost);   
            } else  {
                throw new UserNotAllowed(idUtente,utente.getRuolo().getDescrizione());
            }
    }

    private boolean hadPrivileges(Ruolo ruolo){
        return ruolo.getDescrizione().equalsIgnoreCase("Amministratore") 
        || ruolo.getDescrizione().equalsIgnoreCase("Moderatore");
    }

}
