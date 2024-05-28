package model.data.dao;

import model.Candidato;
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