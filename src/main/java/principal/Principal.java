package principal;

import gui.VentanaBienvenida;
import model.data.DBGenerator;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException {

        String nombreDataBase = "";
        DBGenerator.iniciarBD(nombreDataBase);
        VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
    }
}