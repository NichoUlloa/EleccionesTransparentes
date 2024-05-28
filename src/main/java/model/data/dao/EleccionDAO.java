package model.data.dao;

import model.Eleccion;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;
public class EleccionDAO {

    //metodo para crear o registrar una eleccion nombreEleccion, fechaEleccion, direccionEleccion, candidatos
    public static void registrarEleccion(DSLContext query, Eleccion eleccion){
        Table tablaEleccion = table(name("eleccion"));
        Field[] columnas = tablaEleccion.fields("nombreEleccion", "fechaEleccion", "direccionEleccion", "estado");
        query.insertInto(tablaEleccion, columnas[0], columnas[1], columnas[2], columnas[3])
                .values(eleccion.getNombreEleccion(), eleccion.getFechaEleccion(), eleccion.getDireccionEleccion(), "activo")
                .execute();
    }


    // metodo para validar si una eleccion ya existe en la base de datos
    public static boolean validarExistenciaEleccion(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("eleccion")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }

    // metodo para modificar una eleccion en la base de datos

}
// ejemplo metodo registrar
// // metodo para registrar un producto en la base de datos
//    public static void registrarProducto(DSLContext query, Producto producto){
//        Table tablaProducto= table(name("producto"));
//        Field[] columnas = tablaProducto.fields("ID", "nombre","marca","Categoria","precio");
//        query.insertInto(tablaProducto, columnas[0], columnas[1],columnas[2],columnas[3], columnas[4])
//                .values(producto.getId(), producto.getNombre(),producto.getMarca().getMarca(),producto.getCategoria().getCategoria(),producto.getPrecio())
//                .execute();
//    }
