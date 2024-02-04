package it.cefi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.cefi.app.service.DomandaService;
import it.cefi.app.service.RispostaService;

@Controller
@RequestMapping("/")
public class Home {
	@Autowired
	DomandaService domandaService;  
	@Autowired
	RispostaService rispostaService; 
	@GetMapping("/home")
	public String index()
	{
		return "index"; 
	}
	
	@GetMapping("/inserisci")
	public String inserisci()
	{
		return "inserisci"; 
	}
	
	@GetMapping("/modifica")
	public String modifica()
	{
		return "modifica"; 
	}
	
	@GetMapping("/gioca")
	public String gioca()
	{
		return "gioca"; 
	}
	@GetMapping("/via")
	public String via(Model model)
	{
		model.addAttribute("domanda", domandaService.domanda(1)); 
		model.addAttribute("risposte",rispostaService.rispostaPerDomanda(1)); 
		return "via"; 
	}
	@GetMapping("/pagina-finale")
    public String paginaFinale(@RequestParam(name = "punteggio") int punteggio, Model model) {
        model.addAttribute("punteggio",punteggio); 
        model.addAttribute("totale", domandaService.totaleDomande2()); 
		return "pagina-finale"; 
    }
	
	
	
}
