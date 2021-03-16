package it.rizzoli.carbooklogin.model;

public class Pubblicazione {

    private Integer idPubblicazione;
    private String descrizione;
    private String dataPubblicazione;
    private Automobile automobile;
    private Persona persona;

    public Pubblicazione () {}

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

    public String getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(String dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public void setIdPubblicazione(Integer idPubblicazione) {
        this.idPubblicazione = idPubblicazione;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "idPubblicazione=" + idPubblicazione +
                ", descrizione='" + descrizione + '\'' +
                ", dataPubblicazione=" + dataPubblicazione +
                ", idAutomobile=" + automobile +
                ", idPersona=" + persona +
                '}';
    }
}
