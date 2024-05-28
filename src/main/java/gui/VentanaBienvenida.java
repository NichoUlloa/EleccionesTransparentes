package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaBienvenida extends Ventana{
    public static void main(String[] args) {
        VentanaBienvenida ventana = new VentanaBienvenida();
    }

    // componentes de la ventana
    private JLabel textoMenu, textoBienvenida;
    private JButton crearEleccion, registrarCandidato, registrarVotante, votar, resultados, salir;

    public VentanaBienvenida() {
        super("Sistema de Elecciones", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonCrearEleccion();
        generarBotonRegistrarCandidato();
        generarBotonRegistrarVotante();
        generarBotonVotar();
        generarBotonResultados();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Sistema de Elecciones";
        super.generarJLabelEncabezado(textoMenu, textoBienvenida, 150, 10, 300, 50);
    }

    private void generarBotonCrearEleccion() {
        crearEleccion = super.generarBoton("Crear Elección", 150, 70, 200, 40);
        crearEleccion.addActionListener(this);
        this.add(crearEleccion);
    }

    private void generarBotonRegistrarCandidato() {
        registrarCandidato = super.generarBoton("Registrar Candidato", 150, 120, 200, 40);
        registrarCandidato.addActionListener(this);
        this.add(registrarCandidato);
    }

    private void generarBotonRegistrarVotante() {
        registrarVotante = super.generarBoton("Registrar Votante", 150, 170, 200, 40);
        registrarVotante.addActionListener(this);
        this.add(registrarVotante);
    }

    private void generarBotonVotar() {
        votar = super.generarBoton("Votar", 150, 220, 200, 40);
        votar.addActionListener(this);
        this.add(votar);
    }

    private void generarBotonResultados() {
        resultados = super.generarBoton("Resultados", 150, 270, 200, 40);
        resultados.addActionListener(this);
        this.add(resultados);
    }

    private void generarBotonSalir() {
        salir = super.generarBoton("Salir", 150, 380, 200, 40);
        salir.addActionListener(this);
        this.add(salir);
    }

    // Override del método actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearEleccion) {
            VentanaRegistrarEleccion ventanaCrearEleccion = new VentanaRegistrarEleccion();
        } else if (e.getSource() == registrarCandidato) {
            VentanaRegistrarCandidato ventanaRegistrarCandidato = new VentanaRegistrarCandidato();
        } else if (e.getSource() == registrarVotante) {
            VentanaRegistrarVotante ventanaRegistrarVotante = new VentanaRegistrarVotante();
        } else if (e.getSource() == votar) {
            VentanaVotar ventanaVotar = new VentanaVotar();
        } else if (e.getSource() == resultados) {
            VentanaResultados ventanaResultados = new VentanaResultados();
        } else if (e.getSource() == salir) {
            System.exit(0);
        }
    }



}
// ejemplo override
// // Override del método actionPerformed
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == mostrarProductos) {
//            try {
//                String[][] datosProductos = ProductoController.mostrarTodosLosProductos();
//                VentanaTabla ventanaTabla = new VentanaTabla(datosProductos, new String[]{"ID", "Nombre", "Marca", "Categoría", "Precio"});
//            } catch (ClassNotFoundException ex) {
//                ex.printStackTrace();
//            }
//        } else if (e.getSource() == registrarProducto) {
//            VentanaRegistrarProducto ventanaRegistrarProducto = new VentanaRegistrarProducto();
//        } else if (e.getSource() == eliminarProducto) {
//            VentanaEliminarProducto ventanaEliminarProducto = new VentanaEliminarProducto();
//        } else if (e.getSource() == modificarProducto) {
//            VentanaModificarProducto ventanaModificarProducto = new VentanaModificarProducto();
//        } else if (e.getSource() == buscarProducto) {
//            VentanaBuscarProducto ventanaBuscarProducto = new VentanaBuscarProducto();
//        } else if (e.getSource() == salir) {
//            System.exit(0);
//        }
//    }