package org.unitiva.repository;

import org.unitiva.bean.Post;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepositoryBase<Post,Long>{
    public void createPost(Post utente){
        try {
            persist(utente);  
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public void updatePost(Post utente){
        try {
            persist(utente);

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
