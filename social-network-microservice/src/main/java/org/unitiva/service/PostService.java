package org.unitiva.service;

import org.unitiva.bean.Post;
import org.unitiva.bean.Utente;
import org.unitiva.dto.PostDTO;
import org.unitiva.repository.PostRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostService {

    @Inject
    PostRepository postRepository;

    @Inject
    UtenteService utenteService;

    public void save (PostDTO postDTO){
        postRepository.createPost(postDTO);
    }

    public void updatePost (PostDTO postDTO){
        try{
            Long idutenteRepository = postRepository.findById(postDTO.getIdPost()).getUtente().getIdutente();
            if (postDTO.getIdUtente() == idutenteRepository)
                postRepository.updatePost(postDTO);
            else 
                throw new Error("Utente non autorizzato alla modifica del post");
        } catch (Exception e){
            throw new Error(e.getMessage());
        }
    }

    public Post retrieveById (Long id){
        return postRepository.findById(id);
    }

    public void deleteById (Long idPost, Long idUtente){
        try{
            Post post = retrieveById(idPost);
            Utente utente = utenteService.retrieveById(idUtente);
                if (utente.getRuolo().getDescrizione().equalsIgnoreCase("Amministratore") 
                    || utente.getRuolo().getDescrizione().equalsIgnoreCase("Moderatore") 
                    || post.getUtente().getIdutente() == idUtente) {
                        postRepository.deletePost(idPost);           
                } else  {
                    throw new Error("Utente non autorizzato");
                }
            } catch (Exception e){
                throw new Error(e.getMessage());
            }
    }

}
