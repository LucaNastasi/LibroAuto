package database;

import java.util.Date;
import java.util.List;

public class Pubblicazione {

    private int idPubblicazione;
    private String descrizione;
    private Date dataPubblicazione;
    private byte[] media;
    private String nomePersona;


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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public byte[] getMedia() {
        return media;
    }

    public void setMedia(byte[] media) {
        this.media = media;
    }

    public String getNomePersona() {
        return nomePersona;
    }

    public void setNomePersona(String nomePersona) {
        this.nomePersona = nomePersona;
    }
}
