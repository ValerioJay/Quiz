package it.cefi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.app.models.Risposta;
@Repository
public interface RispostaRepository extends JpaRepository<Risposta, Integer>{

}
