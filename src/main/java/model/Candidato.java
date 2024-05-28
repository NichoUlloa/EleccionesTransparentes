package model;

public class Candidato {
    // atributos
    // rut, nombreCompleto, partidoPolitico, cargoQueAspira
    private String rut;
    private String nombreCompleto;
    private String partidoPolitico;
    private Cargo cargoQueAspira;

    // Constructor
    public Candidato(String rut, String nombreCompleto, String partidoPolitico, Cargo cargoQueAspira) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.partidoPolitico = partidoPolitico;
        this.cargoQueAspira = cargoQueAspira;
    }

    public static Object[] values() {
        return new Object[0];
    }

    // Getters
    public String getRut() {
        return rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public Cargo getCargoQueAspira() {
        return cargoQueAspira;
    }
}
