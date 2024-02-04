package it.cefi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.app.models.Domanda;
@Repository
public interface DomandaRepository extends JpaRepository<Domanda, Integer> {

}
