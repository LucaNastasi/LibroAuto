package it.rizzoli.carbooklogin.model;

public class Automobile {
    private Integer idAutomobile;
    private String modello;
    private String stato;
    private Integer chilometraggio;
    private String alimentazione;
    private Integer potenza;
    private String fotoAuto;
    private Integer costo;
    private String cambio;
    private String annoImmatricolazione;
    private String citta;
    private String marca;

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

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public void setAnnoImmatricolazione(String annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "idAutomobile=" + idAutomobile +
                ", modello='" + modello + '\'' +
                ", stato='" + stato + '\'' +
                ", chilometraggio=" + chilometraggio +
                ", alimentazione='" + alimentazione + '\'' +
                ", potenza=" + potenza +
                ", fotoAuto='" + fotoAuto + '\'' +
                ", costo=" + costo +
                ", cambio='" + cambio + '\'' +
                ", annoImmatricolazione='" + annoImmatricolazione + '\'' +
                ", citta='" + citta + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
