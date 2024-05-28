package gui;

import controller.EleccionController;
import model.Cargo;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistrarCandidato extends Ventana{
    public static void main(String[] args) {
        VentanaRegistrarCandidato ventana = new VentanaRegistrarCandidato();
    }

    // componentes de la ventana rut, nombreCompleto, partidoPolitico, cargoQueAspira(enum)
    private JLabel textoMenu, textoRut, textoNombreCompleto, textoPartidoPolitico, textoCargoQueAspira;
    private JTextField campoRut, campoNombreCompleto, campoPartidoPolitico;
    private JComboBox campoCargoQueAspira;
    private JButton botonRegistrar, botonCancelar;

    public VentanaRegistrarCandidato() {
        super("Registrar Candidato", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrar();
        generarBotonCancelar();
        generarCampoRut();
        generarCampoNombreCompleto();
        generarCampoPartidoPolitico();
        generarCampoCargoQueAspira();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Registrar Candidato";
        super.generarJLabelEncabezado(textoMenu, textoBienvenida, 190, 10, 200, 50);
    }

    private void generarBotonRegistrar() {
        String textoBoton = "Registrar Candidato";
        botonRegistrar = super.generarBoton(textoBoton, 55, 400, 170, 20);
        botonRegistrar.addActionListener(this);
        this.add(botonRegistrar);
    }

    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 170, 20);
        botonCancelar.addActionListener(this);
        this.add(botonCancelar);
    }

    private void generarCampoRut() {
        String textoRut = "Rut:";
        super.generarJLabel(this.textoRut, textoRut, 20, 50, 150, 20);
        campoRut = super.generarJTextField(200, 50, 250, 20);
        this.add(campoRut);
    }

    private void generarCampoNombreCompleto() {
        String textoNombreCompleto = "Nombre Completo:";
        super.generarJLabel(this.textoNombreCompleto, textoNombreCompleto, 20, 100, 150, 20);
        campoNombreCompleto = super.generarJTextField(200, 100, 250, 20);
        this.add(campoNombreCompleto);
    }

    private void generarCampoPartidoPolitico() {
        String textoPartidoPolitico = "Partido Político:";
        super.generarJLabel(this.textoPartidoPolitico, textoPartidoPolitico, 20, 150, 150, 20);
        campoPartidoPolitico = super.generarJTextField(200, 150, 250, 20);
        this.add(campoPartidoPolitico);
    }

    private void generarCampoCargoQueAspira() {
        String textoCargoQueAspira = "Cargo que Aspira:";
        super.generarJLabel(this.textoCargoQueAspira, textoCargoQueAspira, 20, 200, 150, 20);
        campoCargoQueAspira = super.generarListaDesplegable(Cargo.values(), 200, 200, 250, 20);
        this.add(campoCargoQueAspira);
    }

    private boolean registrarCandidato() throws ClassNotFoundException {
        if (campoRut.getText().isEmpty() || campoNombreCompleto.getText().isEmpty() || campoPartidoPolitico.getText().isEmpty()) {
            return false;
        } else {
            return EleccionController.registrarCandidato(campoRut.getText(), campoNombreCompleto.getText(), campoPartidoPolitico.getText(), (Cargo) campoCargoQueAspira.getSelectedItem());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            try {
                if (registrarCandidato()) {
                    JOptionPane.showMessageDialog(this, "Candidato registrado correctamente");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Candidato ya ingresado o datos incorrectos");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.botonCancelar) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            this.dispose();
        }
    }



}

// ejemplo override
//  public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == this.botonRegistrar) {
//            try {
//                if(registrarCarrera()) {
//                    JOptionPane.showMessageDialog(this,"Carrera registrada correctamente");
//                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
//                    this.dispose();
//                }
//                else{
//                    JOptionPane.showMessageDialog(this,"Carrera ya ingresada o datos incorrectos");
//                }
//            } catch (ClassNotFoundException ex) {
//                ex.printStackTrace();
//            }
//        }
//        if (e.getSource() == this.botonCancelar){
//            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
//            this.dispose();
//        }
//
//    }

// ejemplo registrar
// private boolean registrarCarrera() throws ClassNotFoundException {
//        if(this.campoCodigoCarrera.getText().length()==0 || this.campoNombre.getText().length()==0 || this.campoSemestres.getText().length()==0){
//            return false;
//        }
//        else{
//            return CarreraController.añadirCarrera(this.campoNombre.getText(),this.campoCodigoCarrera.getText(),Integer.parseInt(this.campoSemestres.getText()));
//
//        }
//    }
