package org.unitiva.repository;

import org.unitiva.bean.Utente;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UtenteRepository implements PanacheRepositoryBase<Utente,Long>{

    public void createUtente(Utente utente){
        try {
            persist(utente);  
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public void updateUtente(Utente utente){
        try {
            persist(utente);

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public void deleteUtente(Long id){
        try {
            deleteById(id);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Utente retrieveUtenteById(Long id){
        try {
            return findById(id);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

}
