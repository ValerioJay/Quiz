package it.cefi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.cefi.app.models.Domanda;
import it.cefi.app.models.RequestData;
import it.cefi.app.models.Risposta;
import it.cefi.app.service.DomandaService;
import it.cefi.app.service.RispostaService;

@RestController
public class GiocaController {

	@Autowired
	RispostaService rispostaService; 
	@Autowired
	DomandaService domandaService; 
	int i=0; 
	int punteggio = 0; 
	boolean quizTerminato = false;  
	@PostMapping("/prossima")
	public ResponseEntity<RequestData> prossima(@RequestBody Risposta RispostaPassata)
	{
		int totale = domandaService.totaleDomande(); 
		if (i==0)
		{
			punteggio=0; 
		}
		quizTerminato=false; 
		List <Domanda> domande = domandaService.domande(); 
		Domanda domandaDaControllre =  domande.get(i); 
		int IndiceCorrente = domandaDaControllre.getIdDomanda(); 
		Risposta rispDaControllare  = rispostaService.rispostaById(IndiceCorrente);
		Risposta rispDaControllare2 = rispostaService.rispostaByIdRisposta(rispDaControllare.getIdRisposta()-1);
		Risposta rispDaControllare3 = rispostaService.rispostaByIdRisposta(rispDaControllare.getIdRisposta()-2);
		Risposta rispDaControllare4 = rispostaService.rispostaByIdRisposta(rispDaControllare.getIdRisposta()-3);
		
		if(rispDaControllare.getTestoRisposta().equals(RispostaPassata.getTestoRisposta()))
				{
					if (rispDaControllare.getCorretta()==true && RispostaPassata.getCorretta()==true)
					{
						punteggio++; 
					}
				}
		else if(rispDaControllare2.getTestoRisposta().equals(RispostaPassata.getTestoRisposta()))
		{
			if (rispDaControllare2.getCorretta()==true && RispostaPassata.getCorretta()==true)
			{
				punteggio++; 
			}
		}
		else if(rispDaControllare3.getTestoRisposta().equals(RispostaPassata.getTestoRisposta()))
		{
			if (rispDaControllare3.getCorretta()==true && RispostaPassata.getCorretta()==true)
			{
				punteggio++; 
			}
		}
		else if(rispDaControllare4.getTestoRisposta().equals(RispostaPassata.getTestoRisposta()))
		{
			if (rispDaControllare4.getCorretta()==true && RispostaPassata.getCorretta()==true)
			{
				punteggio++; 
			}
		}
		
		i++;
		if (i==domande.size())
		{
			quizTerminato = true;
			i=0; 
			totale=domandaService.totaleDomande2(); 
			RequestData requestdata = new RequestData(null, null, null, null, null, punteggio, quizTerminato, totale); 
			return ResponseEntity.ok(requestdata);
		}
		else
		{
			Domanda domanda = domande.get(i); 
			Risposta risposta1 = rispostaService.rispostaById(domanda.getIdDomanda());
			Risposta risposta2 = rispostaService.rispostaByIdRisposta(risposta1.getIdRisposta()-1);
			Risposta risposta3 = rispostaService.rispostaByIdRisposta(risposta1.getIdRisposta()-2);
			Risposta risposta4 = rispostaService.rispostaByIdRisposta(risposta1.getIdRisposta()-3);
			RequestData requestdata = new RequestData(domanda, risposta1, risposta2, risposta3, risposta4, punteggio, quizTerminato, totale); 
			return ResponseEntity.ok(requestdata);
		}

				
	}
}
