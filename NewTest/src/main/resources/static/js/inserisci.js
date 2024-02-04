document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("inserisci").onsubmit = function (e) {
        e.preventDefault();
        submit();
    };
});

function submit() {
    let domanda = document.getElementById("domanda").value;
    let risposta1 = document.getElementById("risposta1").value;
    let risposta2 = document.getElementById("risposta2").value;
    let risposta3 = document.getElementById("risposta3").value;
    let risposta4 = document.getElementById("risposta4").value;
    let vero1 = document.getElementById("vero1").checked;
    let vero2 = document.getElementById("vero2").checked;
    let vero3 = document.getElementById("vero3").checked;
    let vero4 = document.getElementById("vero4").checked;

    let Domanda = {
        testoDomanda: domanda
    };

    let Risposta1 = {
        testoRisposta: risposta1,
        corretta: vero1
    };

    let Risposta2 = {
        testoRisposta: risposta2,
        corretta: vero2
    };

    let Risposta3 = {
        testoRisposta: risposta3,
        corretta: vero3
    };

    let Risposta4 = {
        testoRisposta: risposta4,
        corretta: vero4
    };

    let requestdata = {
        domanda: Domanda,
        risposta1: Risposta1,
        risposta2: Risposta2,
        risposta3: Risposta3,
        risposta4: Risposta4
    };
	
    fetch("/salva", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestdata)
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);

        // Aggiungi il log per verificare se il reset funziona
        console.log("Resetting form");

        // Ripulisci la form
        document.getElementById("inserisci").reset();
        
    }).catch(error => console.error('Error:', error));
}
