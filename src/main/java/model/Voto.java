package model;

public class Voto {
    // atributos
    // candidatoElegido, fechaVotacion
    private Candidato candidatoElegido;
    private String fechaVotacion;

    // Constructor
    public Voto(Candidato candidatoElegido, String fechaVotacion) {
        this.candidatoElegido = candidatoElegido;
        this.fechaVotacion = fechaVotacion;
    }

    // Getters

    public Candidato getCandidatoElegido() {
        return candidatoElegido;
    }

    public String getFechaVotacion() {
        return fechaVotacion;
    }
}
