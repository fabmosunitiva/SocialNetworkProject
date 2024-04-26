package org.unitiva.repository;

import org.unitiva.bean.Post;
import org.unitiva.dto.PostDTO;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostRepository implements PanacheRepositoryBase<Post,Long>{
    
    @Inject
    UtenteRepository utenteRepository;
    
    public void createPost(PostDTO postDTO){
        try {
            Post post = new Post();
            post.setTitolo(postDTO.getTitolo());
            post.setCorpo(postDTO.getCorpo());
            post.setUtente(utenteRepository.retrieveUtenteById(postDTO.getIdUtente()));
            persist(post);  
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public void updatePost(PostDTO postDTO){
        try {
            Post post = findById(postDTO.getIdPost());
            post.setTitolo(postDTO.getTitolo());
            post.setCorpo(postDTO.getCorpo());
            persist(post);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public void deletePost(Long id){
        try {
            deleteById(id);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Post retrievePostById(Long id){
        return findById(id);
    }
}
