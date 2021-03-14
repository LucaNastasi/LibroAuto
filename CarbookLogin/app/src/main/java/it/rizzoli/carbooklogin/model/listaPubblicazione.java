package it.rizzoli.carbooklogin.model;

public class listaPubblicazione {

    private String marca;
    private String modello;
    private Integer costo;
    private Integer chilometraggio;
    private String dataPubblicazione;
    private Integer potenza;
    private String stato;
    private String username;


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getChilometraggio() {
        return chilometraggio;
    }

    public void setChilometraggio(Integer chilometraggio) {
        this.chilometraggio = chilometraggio;
    }

    public String getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(String dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public Integer getPotenza() {
        return potenza;
    }

    public void setPotenza(Integer potenza) {
        this.potenza = potenza;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "listaPubblicazione{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", costo=" + costo +
                ", chilometraggio=" + chilometraggio +
                ", dataPubblicazione='" + dataPubblicazione + '\'' +
                ", potenza=" + potenza +
                ", stato='" + stato + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
