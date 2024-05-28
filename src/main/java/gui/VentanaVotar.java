package gui;

import model.Candidato;

import javax.swing.*;

public class VentanaVotar extends Ventana{
    public static void main(String[] args) {
        VentanaVotar ventana = new VentanaVotar();
    }


    // componentes de la ventana candidatoElegido, fechaVotacion
    private JLabel textoMenu, textoCandidato, textoFecha;
    private JComboBox campoCandidato;
    private JTextField campoFecha;
    private JButton botonConfirmarVoto, botonCancelar;

    public VentanaVotar() {
        super("Votar", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonConfirmarVoto();
        generarBotonCancelar();
        generarCampoCandidato();
        generarCampoFecha();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Votar";
        super.generarJLabelEncabezado(textoMenu, textoBienvenida, 190, 10, 200, 50);
    }

    private void generarBotonConfirmarVoto() {
        String textoBoton = "Confirmar Voto";
        botonConfirmarVoto = super.generarBoton(textoBoton, 55, 400, 170, 20);
        botonConfirmarVoto.addActionListener(this);
        this.add(botonConfirmarVoto);
    }

    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 170, 20);
        botonCancelar.addActionListener(this);
        this.add(botonCancelar);
    }

    private void generarCampoCandidato() {
        String textoCandidato = "Candidato:";
        super.generarJLabel(this.textoCandidato, textoCandidato, 20, 50, 150, 20);
        campoCandidato = super.generarListaDesplegable(Candidato.values(), 200, 50, 250, 20);
        this.add(campoCandidato);
    }

    private void generarCampoFecha() {
        String textoFecha = "Fecha:";
        super.generarJLabel(this.textoFecha, textoFecha, 20, 100, 150, 20);
        campoFecha = super.generarJTextField(200, 100, 250, 20);
        this.add(campoFecha);
    }







}
