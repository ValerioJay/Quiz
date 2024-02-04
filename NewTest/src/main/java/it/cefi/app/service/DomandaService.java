package it.cefi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.app.models.Domanda;
import it.cefi.app.repositories.DomandaRepository;

@Service
public class DomandaService {

	@Autowired
	DomandaRepository domandaRepository; 
	
	public void salvaDomanda(Domanda d)
	{
		domandaRepository.save(d); 
	}
	
	public List<Domanda> domande()
	{
		List<Domanda> domande = domandaRepository.findAll();
		return domande; 
	}
	public Domanda domanda(int id)
	{
		Domanda domanda = new Domanda(); 
		List<Domanda> domande = domande(); 
		for (Domanda d : domande)
		{
			while (d==null)
			{
				id++; 
			}
			if (d.getIdDomanda()==id)
			{
				domanda=d; 
			}
		}
		return domanda; 
	}
	public int totaleDomande()
	{
		List<Domanda> domande = domandaRepository.findAll(); 
		int indice = 0;  
		for(Domanda d:domande)
		{
			indice=d.getIdDomanda(); 
		}
		
		return indice; 
	}
	public int totaleDomande2()
	{
		List<Domanda> domande = domandaRepository.findAll(); 
		
		return domande.size(); 
	}
	
	public void cancellaDomanda (int id)
	{
		
		List<Domanda>domande = domandaRepository.findAll();
		for (Domanda x : domande)
			{
				if (x.getIdDomanda()==id)
				{
					domandaRepository.delete(x);
				}
			}
	}
}
