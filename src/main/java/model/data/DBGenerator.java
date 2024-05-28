package model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;
import java.sql.Connection;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {
    // metodo inicial para crear una base de datos y sus respectivas tablas en caso de que no exista
    // ** este apartado es necesario modificarlo
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaCandidato(create);
        crearTablaVotante(create);
        crearTablaEleccion(create);
        crearTablaVoto(create);
        relacionarTabla(create, "Voto", "rutCandidato", "Candidato");
        DBConnector.closeConnection();
    }

    // metodo para conectarse a una base de datos ya creada
    public static DSLContext conectarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    // crea una base de datos en caso de que no exista
    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    // actualiza la conexion inicial para conectar a la base de datos
    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    // metodo estandar para crear una tabla Candidato rut, nombreCompleto, partidoPolitico, cargoQueAspira
    private static void crearTablaCandidato(DSLContext create) {
        create.createTableIfNotExists("Candidato")
                .column("rut", VARCHAR(12))
                .column("nombreCompleto", VARCHAR(100))
                .column("partidoPolitico", VARCHAR(50))
                .column("cargoQueAspira", VARCHAR(50))
                .constraint(primaryKey("rut"))
                .execute();
    }

    // metodo estandar para crear una tabla Votante rut, nombreCompleto, numeroTelefono, direccion, preferenciaPolitica
    private static void crearTablaVotante(DSLContext create) {
        create.createTableIfNotExists("Votante")
                .column("rut", VARCHAR(12))
                .column("nombreCompleto", VARCHAR(100))
                .column("numeroTelefono", VARCHAR(12))
                .column("direccion", VARCHAR(100))
                .column("preferenciaPolitica", VARCHAR(50))
                .constraint(primaryKey("rut"))
                .execute();
    }

    // metodo estandar para crear una tabla Eleccion nombreEleccion, fechaEleccion, direccionEleccion,
    private static void crearTablaEleccion(DSLContext create) {
        create.createTableIfNotExists("Eleccion")
                .column("nombreEleccion", VARCHAR(100))
                .column("fechaEleccion", VARCHAR(50))
                .column("direccionEleccion", VARCHAR(100))
                .constraint(primaryKey("nombreEleccion"))
                .execute();
    }

    // metodo estandar para crear una tabla Voto candidatoElegido, fechaVotacion
    private static void crearTablaVoto(DSLContext create) {
        create.createTableIfNotExists("Voto")
                .column("candidatoElegido", VARCHAR(12))
                .column("fechaVotacion", VARCHAR(50))
                .constraint(primaryKey("fechaVotacion"))
                .execute();
    }

    // relaciona dos tablas a traves de una clave foranea, usar solo si se relacionan tablas
    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }
}