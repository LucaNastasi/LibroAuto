package model;

public class Automobile {
    private Integer idAutomobile;
    private String modello;
    private String stato;
    private Integer chilometraggio;
    private String alimentazione;
    private Integer potenza;
    private String fotoAuto;
    private Integer prezzo;
    private String annoImmatricolazione;
    private String citta;

    public Automobile(){

    }

    public Integer getIdAutomobile() {
        return idAutomobile;
    }

    public void setIdAutomobile(Integer idAutomobile) {
        this.idAutomobile = idAutomobile;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Integer getChilometraggio() {
        return chilometraggio;
    }

    public void setChilometraggio(Integer chilometraggio) {
        this.chilometraggio = chilometraggio;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public Integer getPotenza() {
        return potenza;
    }

    public void setPotenza(Integer potenza) {
        this.potenza = potenza;
    }

    public String getFotoAuto() {
        return fotoAuto;
    }

    public void setFotoAuto(String fotoAuto) {
        this.fotoAuto = fotoAuto;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    public String getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public void setAnnoImmatricolazione(String annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
