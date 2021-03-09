package model;

import java.util.Date;
import java.util.List;

public class Pubblicazione {

    private Integer idPubblicazione;
    private String descrizione;
    private Date dataPubblicazione;

    public Pubblicazione(String d){
        this.descrizione = d;
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




}
