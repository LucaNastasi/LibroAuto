package database;

import java.util.Date;
import java.util.List;

public class Evento {
    private int idEvento;
    private String nomeEvento;
    private String luogo;
    private String descrizione;
    private Date dataEvento;
    private Persona persona;
    private List<Pubblicazione> pubblicazioni;

    public Evento (String nomeEvento, String luogo){
        this.nomeEvento = nomeEvento;
        this.luogo = luogo;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Pubblicazione> getPubblicazioni() {
        return pubblicazioni;
    }

    public void setPubblicazioni(List<Pubblicazione> pubblicazioni) {
        this.pubblicazioni = pubblicazioni;
    }
}
