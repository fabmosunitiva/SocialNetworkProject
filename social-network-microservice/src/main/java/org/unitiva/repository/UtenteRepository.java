package org.unitiva.repository;

import org.unitiva.bean.Utente;
import org.unitiva.exception.database.DataAccessException;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UtenteRepository implements PanacheRepositoryBase<Utente, Long> {

    public Utente createUtente(Utente utente) throws DataAccessException{
        try {
            persistAndFlush(utente);
            return utente;  
        } catch (Exception e) {
            throw new DataAccessException("Impossibile eseguire la creazione dell'utente", e.getCause(),false,true);
        }
    }

    public void updateUtente(Utente utente) throws DataAccessException {
        try {
            persist(utente);

        } catch (Exception e) {
            throw new DataAccessException("Impossibile eseguire l'update dell'utente", e.getCause(), false, true);
        }
    }

    public void deleteUtente(Long id) throws DataAccessException {
        try {
            deleteById(id);
        } catch (Exception e) {
            throw new DataAccessException("Impossibile eseguire la delete dell'utente", e.getCause(), false, true);
        }
    }

    public Utente retrieveUtenteById(Long id) throws DataAccessException {
        try {
            return findById(id);
        } catch (Exception e) {
            throw new DataAccessException("Impossibile eseguire la retrieve dell'utente", e.getCause(), false, true);
        }
    }

}
