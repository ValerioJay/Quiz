
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("rispondi").onsubmit = function (e) {
        e.preventDefault();
        submit();
    };
});



function submit() {
   try {
        let domandaElement = document.getElementById("domanda");
        let risposta1Element = document.getElementById("risposta1");
        let risposta2Element = document.getElementById("risposta2");
        let risposta3Element = document.getElementById("risposta3");
        let risposta4Element = document.getElementById("risposta4");
        let vero1Element = document.getElementById("vero1");
        let vero2Element = document.getElementById("vero2");
        let vero3Element = document.getElementById("vero3");
        let vero4Element = document.getElementById("vero4");

        // Verifica se tutti gli elementi sono presenti
        if (!domandaElement || !risposta1Element || !risposta2Element || !risposta3Element || !risposta4Element || !vero1Element || !vero2Element || !vero3Element || !vero4Element) {
            throw new Error("Uno o più elementi non sono stati trovati.");
        }

        let domanda = domandaElement.innerText;
        
        let risposta1 = {
            testoRisposta: risposta1Element.innerText,
            corretta: vero1Element.checked
        };
        let risposta2 = {
            testoRisposta: risposta2Element.innerText,
            corretta: vero2Element.checked
        };
        let risposta3 = {
            testoRisposta: risposta3Element.innerText,
            corretta: vero3Element.checked
        };
        let risposta4 = {
            testoRisposta: risposta4Element.innerText,
            corretta: vero4Element.checked
        };

        // Determina quale risposta è stata selezionata
        let rispostaSelezionata = vero1Element.checked ? risposta1 :
                                 vero2Element.checked ? risposta2 :
                                 vero3Element.checked ? risposta3 :
                                 vero4Element.checked ? risposta4 : null;

        if (!rispostaSelezionata) {
            throw new Error("Nessuna risposta selezionata.");
        }

        let requestdata = rispostaSelezionata
        
		
        fetch('/prossima', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestdata)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Errore nella richiesta: ${response.status} - ${response.statusText}`);
            }
            return response.json();
        })
        .then(data => {
			console.log(data)
			if (data.quizTerminato)
			{
				  console.log(data);
  				 if (data.quizTerminato) {
     				 var url = '/pagina-finale?punteggio=' + data.punteggio;
       				 window.location.href = url;
        									}
        	}
			else
			{
            document.getElementById("rispondi").reset();
            document.getElementById("domanda").innerText = data.domanda.testoDomanda;
            document.getElementById("risposta1").innerText = data.risposta1.testoRisposta;
            document.getElementById("risposta2").innerText = data.risposta2.testoRisposta;
            document.getElementById("risposta3").innerText = data.risposta3.testoRisposta;
            document.getElementById("risposta4").innerText = data.risposta4.testoRisposta;
            document.getElementById("punteggio").innerText = data.punteggio; 
            }
        })
        .catch(error => console.error('Errore durante la richiesta:', error));
    } catch (error) {
        console.error('Errore generale:', error);
    }
}

/*
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("rispondi").onsubmit = function (e) {
        e.preventDefault();
        submit();
    };
});

function resetForm() {
    document.getElementById("rispondi").reset();
}

function updateDOM(data) {
    document.getElementById("domanda").innerText = data.domanda.testoDomanda;
    document.getElementById("risposta1").innerText = data.risposta1.testoRisposta;
    document.getElementById("risposta2").innerText = data.risposta2.testoRisposta;
    document.getElementById("risposta3").innerText = data.risposta3.testoRisposta;
    document.getElementById("risposta4").innerText = data.risposta4.testoRisposta;
    document.getElementById("punteggio").innerText = data.punteggio;
}

function handleQuizTerminato(data) {
    if (data.quizTerminato) {
        console.log(data);
        var url = '/pagina-finale?punteggio=' + data.punteggio;
        window.location.href = url;
    } else {
        resetForm();
        updateDOM(data);
    }
}

function submit() {
    try {
        let domandaElement = document.getElementById("domanda");
        let vero1Element = document.getElementById("vero1");
        let vero2Element = document.getElementById("vero2");
        let vero3Element = document.getElementById("vero3");
        let vero4Element = document.getElementById("vero4");

        if (!domandaElement || !vero1Element || !vero2Element || !vero3Element || !vero4Element) {
            throw new Error("Uno o più elementi non sono stati trovati.");
        }

        let rispostaSelezionata = vero1Element.checked ? 1 :
                                 vero2Element.checked ? 2 :
                                 vero3Element.checked ? 3 :
                                 vero4Element.checked ? 4 : null;

        if (!rispostaSelezionata) {
            throw new Error("Nessuna risposta selezionata.");
        }

        let requestdata = { rispostaSelezionata: rispostaSelezionata };

        fetch('/prossima', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestdata)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Errore nella richiesta: ${response.status} - ${response.statusText}`);
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            handleQuizTerminato(data);
        })
        .catch(error => console.error('Errore durante la richiesta:', error));
    } catch (error) {
        console.error('Errore generale:', error);
    }
}
*/

