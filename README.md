## TCP (Cu conexiune)

### Realizarea conexiunii
Se bazează pe mecanismul **3-way handshake**:
- Clientul trimite un pachet **SYN**
- Serverul răspunde cu **SYN-ACK**
- Clientul confirmă cu **ACK**

Această procedură asigură că ambele părți sunt pregătite pentru comunicare.

### Trimiterea mesajelor
Datele sunt trimise sub formă de **segmente**.

TCP este un protocol fiabil:
- Pentru fiecare segment primit, destinatarul trimite o confirmare (**ACK**)
- Dacă un pachet se pierde, acesta este retransmis


## UDP (Fără conexiune)

### Realizarea conexiunii
Această etapă lipsește complet:
- Nu există handshake inițial
- Clientul trimite direct datele către adresa IP și portul serverului
- Nu se verifică starea serverului

### Trimiterea mesajelor
Datele sunt trimise sub formă de **datagrame**.

UDP NU garantează:
- Livrarea pachetelor
- Ordinea acestora
- Confirmarea primirii


## Diferențe Observate

- **Handshake**: TCP necesită stabilirea unei sesiuni înainte de transfer, în timp ce UDP este imediat (fără handshake)
- **Confirmări**: TCP utilizează pachete de tip ACK pentru validarea recepției, UDP nu folosește confirmări
