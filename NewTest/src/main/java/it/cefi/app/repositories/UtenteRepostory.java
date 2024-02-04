package it.cefi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.cefi.app.models.Utente;

@Repository
public interface UtenteRepostory extends JpaRepository <Utente, String> {

	Utente findByUsername(String username);
}
