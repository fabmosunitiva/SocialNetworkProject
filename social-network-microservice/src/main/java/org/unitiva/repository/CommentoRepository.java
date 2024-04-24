package org.unitiva.repository;

import org.unitiva.bean.Commento;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommentoRepository implements PanacheRepositoryBase<Commento,Long> {

    public void save (Commento commento){
        persist(commento);
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
