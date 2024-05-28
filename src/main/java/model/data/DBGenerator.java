package model.data;

public class DBGenerator {
    // metodo inicial para crear una base de datos y sus respectivas tablas en caso de que no exista
    // ** este apartado es necesario modificarlo
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);

}
