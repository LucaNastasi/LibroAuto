package database;

import java.util.Date;

public class Pubblicazione {

    int idPubblicazione;
    String nomePersona;
    String descrizione;

    public Pubblicazione(String n, String descrizione){
        this.nomePersona = n;
        this.descrizione = descrizione;
    }

    public int getIdPubblicazione() {
        return idPubblicazione;
    }

    public void setIdPubblicazione(int idPubblicazione) {
        this.idPubblicazione = idPubblicazione;
    }

    public String getNomePersona() {
        return nomePersona;
    }

    public void setNomePersona(String nomePersona) {
        this.nomePersona = nomePersona;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

}
