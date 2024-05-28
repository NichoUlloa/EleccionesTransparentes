package gui;

import controller.EleccionController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaCrearEleccion extends Ventana {
    public static void main(String[] args) {
        VentanaCrearEleccion ventanaCrearEleccion = new VentanaCrearEleccion();
    }

    // componente de la ventana nombreEleccion, fechaEleccion, direccionEleccion, candidatos
    private JLabel textoMenu, textoNombreEleccion, textoFechaEleccion, textoDireccionEleccion, textoCandidatos;
    private JTextField campoNombreEleccion, campoFechaEleccion, campoDireccionEleccion;
    private JButton botonCrearEleccion, botonCancelar;

    public VentanaCrearEleccion() {
        super("Crear Elección", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonCrearEleccion();
        generarBotonCancelar();
        generarCampoNombreEleccion();
        generarCampoFechaEleccion();
        generarCampoDireccionEleccion();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Crear Elección";
        super.generarJLabelEncabezado(textoMenu, textoBienvenida, 190, 10, 200, 50);
    }

    private void generarBotonCrearEleccion() {
        String textoBoton = "Crear Elección";
        botonCrearEleccion = super.generarBoton(textoBoton, 55, 400, 170, 20);
        botonCrearEleccion.addActionListener(this);
        this.add(botonCrearEleccion);
    }

    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 170, 20);
        botonCancelar.addActionListener(this);
        this.add(botonCancelar);
    }

    private void generarCampoNombreEleccion() {
        String textoNombreEleccion = "Nombre de la Elección:";
        super.generarJLabel(this.textoNombreEleccion, textoNombreEleccion, 20, 50, 150, 20);
        campoNombreEleccion = super.generarJTextField(200, 50, 250, 20);
        this.add(campoNombreEleccion);
    }

    private void generarCampoFechaEleccion() {
        String textoFechaEleccion = "Fecha de la Elección:";
        super.generarJLabel(this.textoFechaEleccion, textoFechaEleccion, 20, 100, 150, 20);
        campoFechaEleccion = super.generarJTextField(200, 100, 250, 20);
        this.add(campoFechaEleccion);
    }

    private void generarCampoDireccionEleccion() {
        String textoDireccionEleccion = "Dirección de la Elección:";
        super.generarJLabel(this.textoDireccionEleccion, textoDireccionEleccion, 20, 150, 150, 20);
        campoDireccionEleccion = super.generarJTextField(200, 150, 250, 20);
        this.add(campoDireccionEleccion);
    }

   private boolean registrarEleccion() throws ClassNotFoundException {
        if(this.campoNombreEleccion.getText().length()==0 || this.campoFechaEleccion.getText().length()==0 || this.campoDireccionEleccion.getText().length()==0){
            return false;
        }
        else{
            return EleccionController.registrarEleccion(this.campoNombreEleccion.getText(),this.campoFechaEleccion.getText(),this.campoDireccionEleccion.getText());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonCrearEleccion) {
            try {
                if(registrarEleccion()) {
                    JOptionPane.showMessageDialog(this,"Eleccion registrada correctamente");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Eleccion ya ingresada o datos incorrectos");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.botonCancelar){
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
