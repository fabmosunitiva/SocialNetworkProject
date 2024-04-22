package org.unitiva.repository;

import org.unitiva.bean.Pagina;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaginaRepository implements PanacheRepositoryBase<Pagina,Long> {

}
