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
public class VotacionDAO {
    // metodo registrarVotacion candidatoElegido, fechaVotacion
    public static void registrarVotacion(DSLContext query, Candidato candidato, String fechaVotacion) {
        Table tablaVotacion = table(name("votacion"));
        Field[] columnas = tablaVotacion.fields("candidatoElegido", "fechaVotacion");
        query.insertInto(tablaVotacion, columnas[0], columnas[1])
                .values(candidato.getNombreCompleto(), fechaVotacion)
                .execute();
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
