package model;

public class Persona {
    private Integer id;
    private String email;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String telefono;
    private String citta;

    public Persona(String email, String nome, String cognome, String username, String password, String telefono, String citta) {
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.telefono = telefono;
        this.citta = citta;
    }

    public Persona() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }


}
