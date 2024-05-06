package org.unitiva.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.unitiva.bean.Post;
import org.unitiva.dto.PostDTO;
import org.unitiva.exception.database.DataAccessException;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class PostRepository implements PanacheRepositoryBase<Post,Long>{
    
    @Inject
    UtenteRepository utenteRepository;
    
    public Post createPost(PostDTO postDTO) throws DataAccessException{
        try {
            Post post = new Post();
            post.setTitolo(postDTO.getTitolo());
            post.setCorpo(postDTO.getCorpo());
            post.setUtente(utenteRepository.retrieveUtenteById(postDTO.getIdUtente()));
            persist(post);  
            return post;
        } catch (Exception e) {
            throw new DataAccessException("Impossibile eseguire la creazione del post", e.getCause(),false,true);
        }
    }

    public void updatePost(PostDTO postDTO) throws DataAccessException{
        try {
            Post post = findById(postDTO.getIdPost());
            post.setTitolo(postDTO.getTitolo());
            post.setCorpo(postDTO.getCorpo());
            persist(post);
        } catch (Exception e) {
            throw new DataAccessException("Impossibile eseguire l'update del post", e.getCause(),false,true);
        }
    }

    public void deletePost(Long id) throws DataAccessException{
        try {
            deleteById(id);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Post retrievePostById(Long id) throws DataAccessException{
        return findById(id);
    }
}
