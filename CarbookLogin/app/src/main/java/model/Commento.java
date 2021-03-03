package model;

public class Commento {

    int idCommento;
    String nomeUtente;
    String contenutoCommento;

    public Commento(String n, String c){
        this.nomeUtente= n;
        this.contenutoCommento = c;
    }

    public int getIdCommento() {
        return idCommento;
    }

    public void setIdCommento(int idCommento) {
        this.idCommento = idCommento;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getContenutoCommento() {
        return contenutoCommento;
    }

    public void setContenutoCommento(String contenutoCommento) {
        this.contenutoCommento = contenutoCommento;
    }
}
