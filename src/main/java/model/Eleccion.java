package model;

import java.util.ArrayList;

public class Eleccion {
    // Atributos
    // nombreEleccion, fechaEleccion, direccionEleccion, candidatos
    private String nombreEleccion;
    private String fechaEleccion;
    private String direccionEleccion;
    private ArrayList<Candidato> candidatos;

    // Constructor
    public Eleccion(String nombreEleccion, String fechaEleccion, String direccionEleccion) {
        this.nombreEleccion = nombreEleccion;
        this.fechaEleccion = fechaEleccion;
        this.direccionEleccion = direccionEleccion;
    }

    // Getters
    public String getNombreEleccion() {
        return nombreEleccion;
    }

    public String getFechaEleccion() {
        return fechaEleccion;
    }

    public String getDireccionEleccion() {
        return direccionEleccion;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }
}
