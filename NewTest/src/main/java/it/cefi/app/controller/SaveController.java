package it.cefi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.app.models.Domanda;
import it.cefi.app.models.RequestData;
import it.cefi.app.models.Risposta;
import it.cefi.app.repositories.DomandaRepository;
import it.cefi.app.repositories.RispostaRepository;



@RestController
public class SaveController {
	
	@Autowired
	RispostaRepository rispostaRepository;
	
	@Autowired
	DomandaRepository domandaRepository; 
	
	@PostMapping("/salva")
	public ResponseEntity<String> salvaDomanda(@RequestBody RequestData requestData) {
        // Estrarre i dati dalla richiesta
		
        Domanda domanda = requestData.getDomanda();
        Risposta risposta1 = requestData.getRisposta1();
        Risposta risposta2 = requestData.getRisposta2();
        Risposta risposta3 = requestData.getRisposta3();
        Risposta risposta4 = requestData.getRisposta4();
        risposta1.setDomanda(domanda);
        risposta2.setDomanda(domanda);
        risposta3.setDomanda(domanda);
        risposta4.setDomanda(domanda);
        
        domandaRepository.save(domanda); 
        rispostaRepository.save(risposta1); 
        rispostaRepository.save(risposta2);
        rispostaRepository.save(risposta3);
        rispostaRepository.save(risposta4);
        
        System.out.println(risposta1.getCorretta());
        return ResponseEntity.ok("{\"message\": \"Domanda e risposte salvate con successo!\"}");
       // return ResponseEntity.ok("Domanda e risposte salvate con successo!");
}
}