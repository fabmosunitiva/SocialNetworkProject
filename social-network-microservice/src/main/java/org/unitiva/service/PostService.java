package org.unitiva.service;

import org.unitiva.bean.Post;
import org.unitiva.repository.PostRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PostService {

    @Inject
    PostRepository postRepository;

    public void save (Post post){
        postRepository.persist(post);
    }

    public Post findById (Long id){
        return postRepository.findById(id);
    }

    public void deleteById (Long id){
        postRepository.deleteById(id);
    }

}
