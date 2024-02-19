package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

public Connection obtenerConexion() {
    Connection connection = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/westbank", "root", "Lucy.170120!");
        System.out.println("Conexión exitosa: " + connection);
    } catch (SQLException e) {
        System.out.println("Error de conexión: " + e.getMessage());
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    return connection;
}

public void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }


}
