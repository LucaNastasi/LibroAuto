package database;

import java.util.Date;

public class Messaggio {
    private int idMessaggio;
    private String contenutoMessaggio;
    private Date DataOraMessaggio;
    private Persona personaM;
    private Persona personaD;

    public Messaggio(){

    }

    public int getIdMessaggio() {
        return idMessaggio;
    }

    public void setIdMessaggio(int idMessaggio) {
        this.idMessaggio = idMessaggio;
    }

    public String getContenutoMessaggio() {
        return contenutoMessaggio;
    }

    public void setContenutoMessaggio(String contenutoMessaggio) {
        this.contenutoMessaggio = contenutoMessaggio;
    }

    public Date getDataOraMessaggio() {
        return DataOraMessaggio;
    }

    public void setDataOraMessaggio(Date dataOraMessaggio) {
        DataOraMessaggio = dataOraMessaggio;
    }

    public Persona getPersonaM() {
        return personaM;
    }

    public void setPersonaM(Persona personaM) {
        this.personaM = personaM;
    }

    public Persona getPersonaD() {
        return personaD;
    }

    public void setPersonaD(Persona personaD) {
        this.personaD = personaD;
    }
}
