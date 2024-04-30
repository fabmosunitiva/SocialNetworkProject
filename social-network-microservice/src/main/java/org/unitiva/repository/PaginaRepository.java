package org.unitiva.repository;

import org.unitiva.bean.Pagina;
import org.unitiva.bean.Utente;
import org.unitiva.dto.PaginaDTO;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PaginaRepository implements PanacheRepositoryBase<Pagina,Long> {

    @Inject
    UtenteRepository utenteRepository;

        public void createPagina(PaginaDTO paginaDTO){
        try {
            Pagina pagina = new Pagina();
            pagina.setNome(paginaDTO.getNome());
            pagina.setDescrizione(paginaDTO.getDescrizione());
            Utente utenteToFind = utenteRepository.retrieveUtenteById(paginaDTO.getIdutente());
            pagina.setUtente(utenteToFind);
            persist(pagina);  
        } catch (Exception e) {
            Log.info("Errore qui");
            throw new Error(e.getMessage());
        }
    }

    public Pagina retrieveById(Long id){
        return findById(id);
    }

}
