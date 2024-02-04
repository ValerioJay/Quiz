package it.cefi.app.models;

public class RequestData {

	private Domanda domanda;
    private Risposta risposta1;
    private Risposta risposta2;
    private Risposta risposta3;
    private Risposta risposta4;
    private int punteggio; 
    private boolean quizTerminato; 
    private int totale; 
	public Domanda getDomanda() {
		return domanda;
	}
	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}
	public Risposta getRisposta1() {
		return risposta1;
	}
	public void setRisposta1(Risposta risposta1) {
		this.risposta1 = risposta1;
	}
	public Risposta getRisposta2() {
		return risposta2;
	}
	public void setRisposta2(Risposta risposta2) {
		this.risposta2 = risposta2;
	}
	public Risposta getRisposta3() {
		return risposta3;
	}
	public void setRisposta3(Risposta risposta3) {
		this.risposta3 = risposta3;
	}
	public Risposta getRisposta4() {
		return risposta4;
	}
	public void setRisposta4(Risposta risposta4) {
		this.risposta4 = risposta4;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	public boolean isQuizTerminato() {
		return quizTerminato;
	}
	public void setQuizTerminato(boolean quizTerminato) {
		this.quizTerminato = quizTerminato;
	}
	public int getTotale() {
		return totale;
	}
	public void setTotale(int totale) {
		this.totale = totale;
	}
	public RequestData(Domanda domanda, Risposta risposta1, Risposta risposta2, Risposta risposta3, Risposta risposta4,
			int punteggio, boolean quizTerminato, int totale) {
		super();
		this.domanda = domanda;
		this.risposta1 = risposta1;
		this.risposta2 = risposta2;
		this.risposta3 = risposta3;
		this.risposta4 = risposta4;
		this.punteggio = punteggio;
		this.quizTerminato = quizTerminato;
		this.totale = totale;
	}
	public RequestData(int punteggio, boolean quizTerminato, int totale) {
		super();
		this.punteggio = punteggio;
		this.quizTerminato = quizTerminato;
		this.totale = totale;
	}
	public RequestData() {
		super();
	}
	
	
	
	
    
	
    
}
