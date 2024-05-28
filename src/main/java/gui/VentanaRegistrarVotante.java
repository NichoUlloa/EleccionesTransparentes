package gui;

import controller.EleccionController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistrarVotante extends Ventana{
    public static void main(String[] args) {
        VentanaRegistrarVotante ventana = new VentanaRegistrarVotante();
    }

    // componentes de la ventana rut, nombreCompleto, numeroTelefono, direccion, preferenciaPolitica
    private JLabel textoMenu, textoRut, textoNombreCompleto, textoNumeroTelefono, textoDireccion, textoPreferenciaPolitica;
    private JTextField campoRut, campoNombreCompleto, campoNumeroTelefono, campoDireccion, campoPreferenciaPolitica;
    private JButton botonRegistrar, botonCancelar;

    public VentanaRegistrarVotante() {
        super("Registrar Votante", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrar();
        generarBotonCancelar();
        generarCampoRut();
        generarCampoNombreCompleto();
        generarCampoNumeroTelefono();
        generarCampoDireccion();
        generarCampoPreferenciaPolitica();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Registrar Votante";
        super.generarJLabelEncabezado(textoMenu, textoBienvenida, 190, 10, 200, 50);
    }

    private void generarBotonRegistrar() {
        String textoBoton = "Registrar Votante";
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

    private void generarCampoNumeroTelefono() {
        String textoNumeroTelefono = "Número de Teléfono:";
        super.generarJLabel(this.textoNumeroTelefono, textoNumeroTelefono, 20, 150, 150, 20);
        campoNumeroTelefono = super.generarJTextField(200, 150, 250, 20);
        this.add(campoNumeroTelefono);
    }

    private void generarCampoDireccion() {
        String textoDireccion = "Dirección:";
        super.generarJLabel(this.textoDireccion, textoDireccion, 20, 200, 150, 20);
        campoDireccion = super.generarJTextField(200, 200, 250, 20);
        this.add(campoDireccion);
    }

    private void generarCampoPreferenciaPolitica() {
        String textoPreferenciaPolitica = "Preferencia Política:";
        super.generarJLabel(this.textoPreferenciaPolitica, textoPreferenciaPolitica, 20, 250, 150, 20);
        campoPreferenciaPolitica = super.generarJTextField(200, 250, 250, 20);
        this.add(campoPreferenciaPolitica);
    }

    // metodo registrarVotante
    private boolean registrarVotante() throws ClassNotFoundException {
        if(this.campoRut.getText().length()==0 || this.campoNombreCompleto.getText().length()==0 || this.campoNumeroTelefono.getText().length()==0 || this.campoDireccion.getText().length()==0 || this.campoPreferenciaPolitica.getText().length()==0){
            return false;
        }
        else{
            return EleccionController.registrarVotante(this.campoRut.getText(),this.campoNombreCompleto.getText(),this.campoNumeroTelefono.getText(),this.campoDireccion.getText(),this.campoPreferenciaPolitica.getText());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            try {
                if(registrarVotante()) {
                    JOptionPane.showMessageDialog(this,"Votante registrado correctamente");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Votante ya ingresado o datos incorrectos");
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

