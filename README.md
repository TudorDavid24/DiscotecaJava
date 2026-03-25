# 🎵 Simulazione Discoteca

Simulazione concorrente di una serata in discoteca, con gestione delle code, risorse limitate, decisioni probabilistiche e riepilogo finale della serata.

---

## 📋 Descrizione

Il sistema simula il flusso di persone all'interno di una discoteca, dalla coda d'ingresso fino all'uscita finale, passando per guardaroba, pista da ballo, bar e bagni.

Ogni persona attraversa le seguenti fasi:

1. **Fila d'ingresso** — due code separate: online (biglietto già acquistato) e in loco (acquisto alla cassa)
2. **Controllo capienza** — l'accesso è consentito solo se ci sono posti disponibili in discoteca e al guardaroba
3. **Guardaroba** — obbligatorio per tutti; la persona può decidere se lasciare il giubbetto o meno
4. **Discoteca** — la persona balla e, a ogni ciclo, decide cosa fare:
   - continuare a ballare
   - andare al bar
   - uscire
5. **Bar** *(opzionale)* — se pieno, la persona torna a ballare
6. **Bagno** *(conseguenza del bar)* — dopo il bar, la persona va al bagno; se pieno, attende fuori

Verso la fine della serata, l'organizzazione chiude progressivamente i servizi per fare defluire il pubblico.

---

## ⚙️ Parametri di simulazione

### Capienza massima per sezione

| Sezione              | Posti massimi |
|----------------------|---------------|
| Fila ingresso online | 20            |
| Fila ingresso in loco| 50            |
| Guardaroba           | 10            |
| Discoteca            | 400           |
| Bar                  | 10            |
| Bagno                | 5             |

### Tempi di attesa (min–max, in millisecondi)

| Transizione                  | Tempo (ms) |
|------------------------------|------------|
| Fila online → guardaroba     | 10–15      |
| Fila in loco → guardaroba    | 20–30      |
| Guardaroba → discoteca       | 0 (senza giubbetto) / 25–35 (con giubbetto) |
| Bar                          | 20–80      |
| Bar → bagno                  | 100–200    |
| In bagno                     | 40–50      |

### Costi

| Voce                        | Prezzo |
|-----------------------------|--------|
| Biglietto online            | 10 €   |
| Biglietto in loco (uomini)  | 20 €   |
| Biglietto in loco (donne)   | 15 €   |
| Guardaroba                  | 5 €    |
| Drink                       | 10 €   |

### Probabilità delle decisioni

**Guardaroba:**
- 80% usa il guardaroba
- 20% non usa il guardaroba

**In discoteca:**
- 80% continua a ballare
- 15% va al bar
- 5% esce

> ⚠️ Se un'opzione non è disponibile (es. bar chiuso, persona senza soldi), le probabilità vengono ricalcolate escludendo l'opzione non disponibile.

---

## ⏱️ Sequenza temporale della serata

| Tempo (secondi) | Evento                                      |
|-----------------|---------------------------------------------|
| 0               | Inizio simulazione                          |
| 45              | Chiusura ingresso (nessuna nuova fila)      |
| 50              | Chiusura del bar                            |
| 55              | Spegnimento della musica                    |
| 60              | Chiusura dei bagni                          |
| 60+             | Attesa uscita di tutte le persone presenti  |

---

## 👤 Attributi di una Persona

Ogni persona nella simulazione è caratterizzata da:

- **Genere** — determina il prezzo del biglietto in loco
- **Modalità acquisto biglietto** — online o in loco
- **Uso del guardaroba** — sì/no (probabilistico)
- **Disponibilità economica** — per acquistare drink
- **Tempo di ingresso** — timestamp di accesso alla discoteca
- **Storico azioni** — sequenza di stati attraversati

---

## 👷 Personale

Il sistema include anche i lavoratori che gestiscono le varie fasi:

- **Addetto alla scansione** — verifica i biglietti online
- **Addetto alla cassa** — gestisce la vendita dei biglietti in loco
- **Gestore del guardaroba** — gestisce il deposito dei giubbetti
- **Barman** — serve i drink al bar

---

## 📊 Riepilogo finale

Al termine della serata (dopo l'uscita di tutte le persone) viene stampato un riepilogo con:

- Numero di **drink acquistati**
- Numero di persone entrate con **biglietto online**
- Numero di persone entrate con **biglietto in loco**
- **Tempo medio** trascorso in discoteca
- Numero di persone presenti **a metà serata**
- **Guadagno totale** della serata

---

## 🗂️ Schema della simulazione

```
[Fila Online] ──┐
                ├──► [Guardaroba] ──► [Discoteca] ──► [Uscita]
[Fila In Loco] ─┘                         │
                                     ┌────┴────┐
                                   [Bar]    [Bagno]
```
---

## 📁 Struttura del progetto

```
discoteca-simulation/
├── README.md
├── src/
│   ├── main.*          # Entry point della simulazione
│   ├── persona.*       # Modello della persona
│   ├── lavoratore.*    # Modello dei lavoratori
│   ├── sezioni/        # Guardaroba, Bar, Bagno, Discoteca
│   └── utils/          # Timer, statistiche, log
└── docs/
    └── schema.png      # Diagramma della simulazione
```

---

## 📝 Note

- La simulazione è **concorrente**: ogni persona è un thread (o processo) indipendente.
- Le risorse condivise (guardaroba, bar, bagno) devono essere gestite con **mutua esclusione** o semafori.
- I tempi sono espressi in **millisecondi** per rendere la simulazione più rapida da eseguire.
