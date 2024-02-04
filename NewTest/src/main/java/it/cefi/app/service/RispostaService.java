package it.cefi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.app.models.Risposta;
import it.cefi.app.repositories.RispostaRepository;

@Service
public class RispostaService {

	@Autowired
	private RispostaRepository rispostaRepository; 
	 
	public void salvaRisposta (Risposta r)
	{
		rispostaRepository.save(r); 
	}
	
	public List<Risposta> risposte()
	{
		return rispostaRepository.findAll(); 
	}
	
	public List<Risposta> rispostaPerDomanda (int id)
	{
		List<Risposta> risposte = risposte(); 
		List<Risposta> rispostePerDomanda = new ArrayList<>(); 
		for (Risposta r : risposte)
		{
			if (r.getDomanda().getIdDomanda()==id)
			{
				rispostePerDomanda.add(r); 
			}
		}
		return rispostePerDomanda; 
	}
	
	public Risposta rispostaById(int id)
	{
		List<Risposta> risposte = risposte(); 
		Risposta risposta = null; 
		for (Risposta r : risposte)
		{
			if (r.getDomanda().getIdDomanda()==id)
			{
				risposta=r;  
			}
		}
		return risposta;
	}
	
	public Risposta rispostaByIdRisposta(int id)
	{
		List<Risposta> risposte = risposte(); 
		Risposta risposta = null; 
		for (Risposta r : risposte)
		{
			if (r.getIdRisposta()==id)
			{
				risposta=r;  
			}
		}
		return risposta;
	}
	
	public void cancellaRisposte (int id)
	{
		
		
		List<Risposta> risposte = rispostaRepository.findAll(); 
		for (Risposta x:risposte)
		{
			if(x.getDomanda().getIdDomanda()==id)
			{
				rispostaRepository.delete(x);
			}
		}
	}
	
	
	
	
	
}
