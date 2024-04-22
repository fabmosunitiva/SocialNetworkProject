package org.unitiva.repository;

import org.unitiva.bean.Commento;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommentoRepository implements PanacheRepositoryBase<Commento,Long> {

}
