package model.data.dao;

import model.Votante;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;
public class VotanteDAO {
    // metodo para registrar un votante en la base de datos rut, nombreCompleto, numeroTelefono, direccion, preferenciaPolitica
    public static void registrarVotante(DSLContext query, Votante votante) {
        Table tablaVotante = table(name("votante"));
        Field[] columnas = tablaVotante.fields("rut", "nombreCompleto", "numeroTelefono", "direccion", "preferenciaPolitica");
        query.insertInto(tablaVotante, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                .values(votante.getRut(), votante.getNombreCompleto(), votante.getNumeroTelefono(), votante.getDireccion(), votante.getPreferenciaPolitica())
                .execute();
    }

    // metodo para validar si un votante ya existe en la base de datos
    public static boolean validarExistenciaVotante(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("votante")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
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
