package org.unitiva.repository;

import org.unitiva.bean.Post;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepositoryBase<Post,Long>{

}
