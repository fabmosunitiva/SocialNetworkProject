package org.unitiva.service;

import org.unitiva.bean.Pagina;
import org.unitiva.repository.PaginaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PaginaService {

    @Inject
    PaginaRepository paginaRepository;

    public void save (Pagina pagina){
        paginaRepository.persist(pagina);
    }

    public Pagina findById (Long id){
        return paginaRepository.findById(id);
    }

    public void deleteById (Long id){
        paginaRepository.deleteById(id);
    }

}
