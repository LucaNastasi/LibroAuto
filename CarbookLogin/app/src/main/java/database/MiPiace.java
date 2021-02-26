package database;

public class MiPiace {
    private int idMiPiace;
    private Persona persona;
    private Pubblicazione pubblicazione;
    private Commento commento;

    public MiPiace(){

    }

    public Integer getIdMiPiace() {
        return idMiPiace;
    }

    public void setIdMiPiace(Integer idMiPiace) {
        this.idMiPiace = idMiPiace;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Pubblicazione getPubblicazione() {
        return pubblicazione;
    }

    public void setPubblicazione(Pubblicazione pubblicazione) {
        this.pubblicazione = pubblicazione;
    }

    public Commento getCommento() {
        return commento;
    }

    public void setCommento(Commento commento) {
        this.commento = commento;
    }
}
