package org.unitiva.repository;

import org.unitiva.bean.Ruolo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RuoloRepository implements PanacheRepositoryBase <Ruolo,Long>{

}
