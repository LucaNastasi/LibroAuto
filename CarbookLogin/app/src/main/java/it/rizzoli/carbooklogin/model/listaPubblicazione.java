package it.rizzoli.carbooklogin.model;

public class listaPubblicazione {

    private String marca;
    private String username;
    private String descrizione;
    private String dataPubblicazione;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "listaPubblicazione{" +
                "marca='" + marca + '\'' +
                ", username='" + username + '\'' +
                ", descrizone='" + descrizione + '\'' +
                ", dataPubblicazione='" + dataPubblicazione + '\'' +
                '}';
    }
}
