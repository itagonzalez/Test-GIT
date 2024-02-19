package negocio;

import conexion.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Cliente {

    private String rut;
    private String dv;
    private String clave;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private int telefono;
    private String tipoCuenta;

    public Cliente() {
    }

    public Cliente(String rut, String dv, String clave, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, int telefono, String tipoCuenta) {
        this.rut = rut;
        this.dv = dv;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
         }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

       public boolean autenticarCliente(String rutConDV, String clave) {
        boolean autenticado = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Separar el RUT y el DV
            String[] partes = rutConDV.split("-");
            String rut = partes[0];
            String dv = partes[1];

            connection = new BaseDatos().obtenerConexion();
            String consulta = "SELECT * FROM Cliente WHERE rut = ? AND dv = ? AND clave = ?";
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, dv);
            preparedStatement.setString(3, clave);
            resultSet = preparedStatement.executeQuery();

            autenticado = resultSet.next(); // Si hay al menos una fila, el usuario está autenticado

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            new BaseDatos().cerrarConexion(connection);
        }

        return autenticado;
    }
 
       
public void obtenerDatosCliente() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = new BaseDatos().obtenerConexion();
        String consulta = "SELECT nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono FROM Cliente WHERE rut = ?";
        preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setString(1, rut);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Establecer los datos del cliente
            nombre = resultSet.getString("nombre");
            apellidoPaterno = resultSet.getString("apellidoPaterno");
            apellidoMaterno = resultSet.getString("apellidoMaterno");
            domicilio = resultSet.getString("domicilio");
            comuna = resultSet.getString("comuna");
            telefono = resultSet.getInt("telefono");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar recursos
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        new BaseDatos().cerrarConexion(connection);
    }
}


    }
