package model;

public class Votante {
    // atributos
    // rut, nombreCompleto, numeroTelefono, direccion, preferenciaPolitica
    private String rut;
    private String nombreCompleto;
    private String numeroTelefono;
    private String direccion;
    private String preferenciaPolitica;

    // Constructor
    public Votante(String rut, String nombreCompleto, String numeroTelefono, String direccion, String preferenciaPolitica) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.preferenciaPolitica = preferenciaPolitica;
    }

    // Getters

    public String getRut() {
        return rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPreferenciaPolitica() {
        return preferenciaPolitica;
    }
}
