package org.unitiva.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Utente> findCompleanno(){
        String query = "from Utente u where month(u.datanascita) = ?1 and day(u.datanascita) = ?2";
        return find(query, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()).list();
    }

    public List<Utente> findCompleanniOggi (){
        List<Utente> listaUtenti = listAll();
        int mese = LocalDate.now().getMonthValue();
        int giorno = LocalDate.now().getDayOfMonth();

        List<Utente> listaCompleanni = new ArrayList<Utente>();

        for (Utente utente : listaUtenti){
                     if (utente.getDatanascita().getMonthValue()==mese && utente.getDatanascita().getDayOfMonth()==giorno){
                        listaCompleanni.add(utente);
                     }
                 }
        return listaCompleanni;
    }

}
