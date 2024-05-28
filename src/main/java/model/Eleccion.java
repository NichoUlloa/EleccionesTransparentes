package model;

import java.util.ArrayList;

public class Eleccion {
    private String nombreEleccion;
    private String fechaEleccion;
    private String direccionEleccion;
    private ArrayList<Candidato> candidatos;

    public Eleccion(String nombreEleccion, String fechaEleccion, String direccionEleccion) {
        this.nombreEleccion = nombreEleccion;
        this.fechaEleccion = fechaEleccion;
        this.direccionEleccion = direccionEleccion;
        this.candidatos = new ArrayList<>();
    }

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

    public void setCandidatos(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}
