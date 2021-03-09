package model;

public class Automobile {
    private Integer idAutomobile;
    private String modello;
    private String stato;
    private Integer chilometri;
    private String alimentazione;
    private Integer potenza;
    private byte [] fotoAuto;
    private Integer prezzo;

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

    public Integer getChilometri() {
        return chilometri;
    }

    public void setChilometri(Integer chilometri) {
        this.chilometri = chilometri;
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

    public byte[] getFotoAuto() {
        return fotoAuto;
    }

    public void setFotoAuto(byte[] fotoAuto) {
        this.fotoAuto = fotoAuto;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }
}
