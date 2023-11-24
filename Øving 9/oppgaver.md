# Oppgave 1
Klassen String inneholder mange metoder. Vi skal nå lage noen flere.
Lag en klasse som heter NyString. Den skal ha en objektvariabel av klassen String. Klassen
NyString skal være immutabel og tilby følgende tjenester:
- Konstruktør som tar et objekt av klassen String som argument.
- Forkorting. Forkortingen skal skje ved at første tegn i hvert ord plukkes ut. Bruk
mellomrom som skille mellom ordene. Eksempel: «denne setningen kan forkortes»
skal forkortes til «dskf». Tips: Bruk String-metoden split(), som returnerer en tabell
med ordene som teksten består av: String() ord = tekst.split()
- Fjerning av tegn. Eksempel: Dersom tegnet ‘e’ fjernes fra teksten «denne setningen
kan forkortes», står vi igjen med «dnn stningn kan forkorts». Tips: Bruk en while-
løkke og for eksempel String-metodene indexOf() og substring().


# Oppgave 2
Lag en klasse for enkel tekstbehandling. Konstruktøren skal ta en tekst som argument.
Klassen skal tilby følgende tjenester:
- Å finne antall ord i teksten.
- Å finne gjennomsnittlig ordlengde. Skilletegn er ikke en del av ordene.
- Å finne gjennomsnittlig antall ord per periode. Bruk punktum, utropstegn, kolon og
spørretegn som skilletegn mellom periodene. Anta at teksten er feilfri, slik at ikke to
eller flere slike tegn følger etter hverandre.
- Å skifte ut et ord med et annet gjennom hele teksten. For eksempel kan en ønske å
skifte ut ordet «finnes» med «fins».
- Å hente ut teksten slik den står, uten endringer.
- Å hente ut teksten, men slik at alle bokstaver er store.
Lag en enkel testklient. Husk å prøve klassen for tekster som inneholder æ, ø og å.