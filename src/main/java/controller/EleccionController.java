package controller;

import model.Cargo;
import model.Candidato;
import model.Eleccion;
import model.Votante;
import model.data.DBConnector;
import model.data.DBGenerator;
import model.data.dao.CandidatoDAO;
import model.data.dao.EleccionDAO;
import model.data.dao.VotanteDAO;
import org.jooq.DSLContext;

import java.util.ArrayList;

public class EleccionController {

    private static final String nombreDataBase = "EleccionesTransparentesDB";

    // metodo registrarElecciones nombreEleccion, fechaEleccion, direccionEleccion, candidatos
    public static boolean registrarEleccion(String nombreEleccion, String fechaEleccion, String direccionEleccion, ArrayList<Candidato> candidatos) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
        if (!EleccionDAO.validarExistenciaEleccion(query, "nombreEleccion", nombreEleccion)) {
            Eleccion eleccion = new Eleccion(nombreEleccion, fechaEleccion, direccionEleccion, candidatos);
            EleccionDAO.registrarEleccion(query, eleccion);
            DBConnector.closeConnection();
            return true;
        } else {
            DBConnector.closeConnection();
            return false;
        }
    }


    // metodo registroCandidato CandidatoDAO rut, nombreCompleto, partidoPolitico, cargoQueAspira
    public static boolean registrarCandidato(String rut, String nombreCompleto, String partidoPolitico, Cargo cargoQueAspira) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
        if (!CandidatoDAO.validarExistenciaCandidato(query, "rut", rut)) {
            Candidato candidato = new Candidato(rut, nombreCompleto, partidoPolitico, cargoQueAspira);
            CandidatoDAO.registrarCandidato(query, candidato);
            DBConnector.closeConnection();
            return true;
        } else {
            DBConnector.closeConnection();
            return false;
        }
    }

    // metodo registro votantes rut, nombreCompleto, numeroTelefono, direccion, preferenciaPolitica
    public static boolean registrarVotante(String rut, String nombreCompleto, String numeroTelefono, String direccion, String preferenciaPolitica) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
        if (!VotanteDAO.validarExistenciaVotante(query, "rut", rut)) {
            Votante votante = new Votante(rut, nombreCompleto, numeroTelefono, direccion, preferenciaPolitica);
            VotanteDAO.registrarVotante(query, votante);
            DBConnector.closeConnection();
            return true;
        } else {
            DBConnector.closeConnection();
            return false;
        }
    }


}

// ejemplo metodo registrarElecciones
// public static boolean registrarProducto(int id, String nombre, Marca marca, Categoria categoria, double precio) throws ClassNotFoundException {
//        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
//        if (!ProductoDAO.validarExistenciaProducto(query, "ID", id)) {
//            Producto producto = new Producto(id, nombre, marca, categoria, precio);
//            ProductoDAO.registrarProducto(query, producto);
//            DBConnector.closeConnection();
//            return true;
//        } else {
//            DBConnector.closeConnection();
//            return false;
//        }
//    }
