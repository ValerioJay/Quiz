package it.cefi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.app.models.Domanda;
import it.cefi.app.service.DomandaService;
import it.cefi.app.service.RispostaService;

@RestController
public class ModificaController {
	
	@Autowired
	DomandaService domandaService;
	
	@Autowired
	RispostaService rispostaService;
	
	@GetMapping("/carica")
	public ResponseEntity<List<Domanda>> carica() 
	{
		List<Domanda> domande = domandaService.domande();
		return new ResponseEntity<>(domande, HttpStatus.OK);
	}
	
	@DeleteMapping("/cancella")
    public String cancellaElemento(@RequestBody Domanda domanda) {
        System.out.println("Cancellare l'elemento con ID: " + domanda.getIdDomanda());
        domandaService.cancellaDomanda(domanda.getIdDomanda()); 
        rispostaService.cancellaRisposte(domanda.getIdDomanda()); 
        return "Elemento cancellato con successo";
    }
}
