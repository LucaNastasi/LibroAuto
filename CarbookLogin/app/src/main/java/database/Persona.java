package database;

public class Persona {
    private int id;
    private String email;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private int eta;
    private String citta;

    public Persona() {
        this.nome = "";
        this.cognome = "";
        this.eta = 0;
        this.email = "";
    }

    public Persona(String nome, String cognome, int eta, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEta() {
        return eta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
