package model.data.dao;

import model.Candidato;
import model.Cargo;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;
public class CandidatoDAO {

    // metodo registrarCandidato rut, nombreCompleto, partidoPolitico, cargoQueAspira
    public static void registrarCandidato(DSLContext query, Candidato candidato) {
        Table tablaCandidato = table(name("candidato"));
        Field[] columnas = tablaCandidato.fields("rut", "nombreCompleto", "partidoPolitico", "cargoQueAspira");
        query.insertInto(tablaCandidato, columnas[0], columnas[1], columnas[2], columnas[3])
                .values(candidato.getRut(), candidato.getNombreCompleto(), candidato.getPartidoPolitico(),
                        candidato.getCargoQueAspira().getCargo())
                .execute();
    }

    // metodo validarExistenciaCandidato
    public static boolean validarExistenciaCandidato(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(DSL.table("candidato")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if (resultados.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    // metodo para obtener todos los candidatos en la base de datos
    public List obtenerCandidatos(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(DSL.table("candidato")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaCandidatos(resultados);
    }

    // metodo para obtener todos los candidatos en la base de datos
    private List obtenerListaCandidatos(Result resultados) {
        List<Candidato> candidatos = new ArrayList<>();
        for (int fila = 0; fila < resultados.size(); fila++) {
            String rut = (String) resultados.getValue(fila, "rut");
            String nombreCompleto = (String) resultados.getValue(fila, "nombreCompleto");
            String partidoPolitico = (String) resultados.getValue(fila, "partidoPolitico");
            String cargoQueAspira = (String) resultados.getValue(fila, "cargoQueAspira");
            candidatos.add(new Candidato(rut, nombreCompleto, partidoPolitico, Cargo.valueOf(cargoQueAspira)));
        }
        return candidatos;
    }

    // metodo exportarCandidatos
    public static String[][] exportarCandidatos(Result resultados) {
        String[][] datosResultado = new String[resultados.size()][4]; // 4 por la cantidad de datos
        for (int registro = 0; registro < resultados.size(); registro++) {
            datosResultado[registro][0] = (String) resultados.getValue(registro, "rut");
            datosResultado[registro][1] = (String) resultados.getValue(registro, "nombreCompleto");
            datosResultado[registro][2] = (String) resultados.getValue(registro, "partidoPolitico");
            datosResultado[registro][3] = (String) resultados.getValue(registro, "cargoQueAspira");
        }
        return datosResultado;

    }

}
// ejemplo registrar
// // metodo para registrar un producto en la base de datos
//    public static void registrarProducto(DSLContext query, Producto producto){
//        Table tablaProducto= table(name("producto"));
//        Field[] columnas = tablaProducto.fields("ID", "nombre","marca","Categoria","precio");
//        query.insertInto(tablaProducto, columnas[0], columnas[1],columnas[2],columnas[3], columnas[4])
//                .values(producto.getId(), producto.getNombre(),producto.getMarca().getMarca(),producto.getCategoria().getCategoria(),producto.getPrecio())
//                .execute();
//    }

// ejemplo // metodo para exportar los datos de la base de datos
//    public static String[][] exportarDatos(Result resultados){
//        String[][] datosResultado=new String[resultados.size()][5]; // 5 por la cantidad de datos
//        for(int registro = 0; registro < resultados.size(); registro ++){
//            datosResultado[registro][0] = String.valueOf((Integer) resultados.getValue(registro,"id"));
//            datosResultado[registro][1] = (String) resultados.getValue(registro,"nombre");
//            datosResultado[registro][2] = (String) resultados.getValue(registro,"marca");
//            datosResultado[registro][3] = (String) resultados.getValue(registro,"categoria");
//            datosResultado[registro][4] = String.valueOf((Double) resultados.getValue(registro,"precio"));
//        }
//        return datosResultado;
//    }