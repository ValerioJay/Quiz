/*
window.onload = function () {
  // Quando la pagina è completamente caricata

  // Effettua una richiesta HTTP GET al tuo server
  fetch('/carica')
    .then(response => {
      if (!response.ok) {
        throw new Error(`Errore HTTP! Status: ${response.status}`);
      }
      return response.json(); // Assume che il server restituisca un JSON
    })
    .then(data => {
      console.log('Dati ricevuti:', data);

      // tabella
      const table = document.createElement('table');
      const thead = document.createElement('thead');
      const tbody = document.createElement('tbody');

      // Creazione delle intestazioni della tabella
      const headerRow = document.createElement('tr');
      const idTh = document.createElement('th');
      idTh.textContent = 'ID';
      headerRow.appendChild(idTh);

      // Aggiungi la colonna Domanda
      const domandaTh = document.createElement('th');
      domandaTh.textContent = 'Domanda';
      headerRow.appendChild(domandaTh);

      // Aggiungi la colonna Radio
      const radioTh = document.createElement('th');
      radioTh.textContent = 'Seleziona';
      headerRow.appendChild(radioTh);

      thead.appendChild(headerRow);
      table.appendChild(thead);

      // Creazione delle righe della tabella con i dati
      data.forEach(rowData => {
        const tr = document.createElement('tr');
        Object.values(rowData).forEach(value => {
          const td = document.createElement('td');
          td.textContent = value;
          tr.appendChild(td);
        });

        // Aggiungi la colonna Radio
        const radioTd = document.createElement('td');
        const radioInput = document.createElement('input');
        radioInput.type = 'radio';
        radioInput.name = 'elementoRadio'; // Assicurati di usare lo stesso nome per tutti i radio button
        radioInput.value = JSON.stringify(rowData);
        radioTd.appendChild(radioInput);
        tr.appendChild(radioTd);

        tbody.appendChild(tr);
      });

      table.appendChild(tbody);

      // Creare un contenitore per la navbar e la tabella
      const container = document.createElement('div');
      container.classList.add('container'); // Aggiungi una classe per lo stile CSS se necessario

      // Aggiungi la tabella al contenitore
      container.appendChild(table);

      // Aggiungi il contenitore al corpo della pagina o a un elemento specifico
      document.body.appendChild(container);

      // Creare il tasto Cancella
      const cancellaButton = document.createElement('button');
      cancellaButton.textContent = 'Cancella';
      cancellaButton.addEventListener('click', cancellaElemento);

      const cancellaButtonContainer = document.createElement('div');
      cancellaButtonContainer.style.textAlign = 'center';
      cancellaButtonContainer.appendChild(cancellaButton);

      document.body.appendChild(cancellaButtonContainer);

      // Funzione per gestire il clic sul tasto Cancella
      function cancellaElemento() {
        const radioSelezionato = document.querySelector('input[name="elementoRadio"]:checked');
        if (radioSelezionato) {
          // Esegui l'azione di cancellazione con l'ID o il valore associato al radio selezionato
          const elementoDaCancellare = JSON.parse(radioSelezionato.value);
          console.log('Cancellare l\'elemento con ID:', elementoDaCancellare);

          // Chiamata Fetch a Spring
          fetch('/cancella', {
            method: 'DELETE', // Specifica il metodo HTTP come DELETE
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(elementoDaCancellare),
          })
            .then(response => {
              if (!response.ok) {
                throw new Error(`Errore HTTP! Status: ${response.status}`);
              }
              console.log('Elemento cancellato con successo.');
              
            })
            .catch(error => {
              console.error('Errore durante la richiesta di cancellazione:', error.message);
            });
        } else {
          console.log('Selezionare un elemento da cancellare');
        }
      }
    })
    .catch(error => {
      console.error('Errore durante la richiesta:', error.message);
    });
};
*/


window.onload = function () {
  // Funzione per creare la tabella
  function createTable(data) {
    const table = document.createElement('table');
    const thead = document.createElement('thead');
    const tbody = document.createElement('tbody');

    // Creazione delle intestazioni della tabella
    const headerRow = document.createElement('tr');
    const idTh = document.createElement('th');
    idTh.textContent = 'ID';
    headerRow.appendChild(idTh);

    // Aggiungi la colonna Domanda
    const domandaTh = document.createElement('th');
    domandaTh.textContent = 'Domanda';
    headerRow.appendChild(domandaTh);

    // Aggiungi la colonna Radio
    const radioTh = document.createElement('th');
    radioTh.textContent = 'Seleziona';
    headerRow.appendChild(radioTh);

    thead.appendChild(headerRow);
    table.appendChild(thead);

    // Creazione delle righe della tabella con i dati
    data.forEach(rowData => {
      const tr = document.createElement('tr');
      Object.values(rowData).forEach(value => {
        const td = document.createElement('td');
        td.textContent = value;
        tr.appendChild(td);
      });

      // Aggiungi la colonna Radio
      const radioTd = document.createElement('td');
      const radioInput = document.createElement('input');
      radioInput.type = 'radio';
      radioInput.name = 'elementoRadio'; // Assicurati di usare lo stesso nome per tutti i radio button
      radioInput.value = JSON.stringify(rowData);
      radioTd.appendChild(radioInput);
      tr.appendChild(radioTd);

      tbody.appendChild(tr);
    });

    table.appendChild(tbody);

    // Aggiungi la tabella al corpo della pagina
    const existingTable = document.getElementById('table-container');
    if (existingTable) {
      // Rimuovi la vecchia tabella se esiste
      existingTable.remove();
    }

    const container = document.createElement('div');
    container.classList.add('container');
    container.id = 'table-container';
    container.appendChild(table);

    document.body.appendChild(container);
  }

  // Funzione per caricare i dati e creare la tabella
  function loadAndCreateTable() {
    fetch('/carica')
      .then(response => {
        if (!response.ok) {
          throw new Error(`Errore HTTP! Status: ${response.status}`);
        }
        return response.json();
      })
      .then(data => {
        console.log('Dati ricevuti:', data);
        createTable(data);
      })
      .catch(error => {
        console.error('Errore durante la richiesta:', error.message);
      });
  }

  // Esegui la funzione iniziale
  loadAndCreateTable();

  // Funzione per gestire il clic sul tasto Cancella
  function cancellaElemento() {
    const radioSelezionato = document.querySelector('input[name="elementoRadio"]:checked');
    if (radioSelezionato) {
      const elementoDaCancellare = JSON.parse(radioSelezionato.value);

      fetch('/cancella', {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(elementoDaCancellare),
      })
        .then(response => {
          if (!response.ok) {
            throw new Error(`Errore HTTP! Status: ${response.status}`);
          }
          console.log('Elemento cancellato con successo.');
          // Dopo la cancellazione, ricarica e aggiorna la tabella
          loadAndCreateTable();
        })
        .catch(error => {
          console.error('Errore durante la richiesta di cancellazione:', error.message);
        });
    } else {
      console.log('Selezionare un elemento da cancellare');
    }
  }

  // Aggiungi il listener al tasto Cancella
  const cancellaButton = document.createElement('button');
  cancellaButton.textContent = 'Cancella';
  cancellaButton.addEventListener('click', cancellaElemento);

  const cancellaButtonContainer = document.createElement('div');
  cancellaButtonContainer.style.textAlign = 'center';
  cancellaButtonContainer.appendChild(cancellaButton);

  document.body.appendChild(cancellaButtonContainer);
};
