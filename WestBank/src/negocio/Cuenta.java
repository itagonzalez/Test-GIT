package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cuenta extends Cliente {

    private String rut;
    private int numero;   
    private int monto;

    public Cuenta() {
        super();
    }
    
      public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean validarNumeroCuenta(String numeroCuenta) {
        boolean numValidar = false;

        if (numeroCuenta.length() == 9) {
            numValidar = true;
        }
        return numValidar;
    }

     // Metodo de Obtener datos de cuenta con query
   public void obtenerDatosCuenta(Connection connection) throws SQLException {
    String query = "SELECT * FROM Cuenta WHERE rutCliente = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, rut);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                numero = resultSet.getInt("numero");
                monto = resultSet.getInt("monto");
                // Puedes acceder al rut directamente, ya que Cuenta hereda de Cliente
                setRut(resultSet.getString("rutCliente")); 
            }
        }
    }
    }
    
     // Metodo de Obtener datos de cuenta con query
    public static Cuenta obtenerCuentaPorNumero(Connection connection, int numeroCuenta) throws SQLException {
    String query = "SELECT * FROM Cuenta WHERE numero = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, numeroCuenta);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setNumero(resultSet.getInt("numero"));
                cuenta.setMonto(resultSet.getInt("monto"));
                cuenta.setRut(resultSet.getString("rutCliente")); 

                return cuenta;
            }
        }
    }
    return null; // Retorna null si no se encuentra la cuenta
}

    public void depositar(Connection connection, int monto) throws SQLException {
        // Actualizar el saldo en la base de datos
        String query = "UPDATE Cuenta SET monto = monto + ? WHERE rutCliente = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, monto);
            preparedStatement.setString(2, rut);
            preparedStatement.executeUpdate();

            // Actualizar el monto en el objeto cuenta
            this.monto += monto;
        }

    }

    public void girar(Connection connection, int monto) throws SQLException {
        // Actualizar el saldo en la base de datos
        String query = "UPDATE Cuenta SET monto = monto - ? WHERE rutCliente = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, monto);
            preparedStatement.setString(2, rut);
            preparedStatement.executeUpdate();

            // Actualizar el monto en el objeto cuenta
            this.monto -= monto;
        }
    }

public void transferir(Connection connection, int monto, int numeroCuentaDestino) throws SQLException {
        // Verificar que haya suficiente saldo en la cuenta de origen
        if (this.monto < monto) {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
            return;
        }

        // Realizar el giro en la cuenta de origen
        girar(connection, monto);

        // Obtener la cuenta de destino
        Cuenta cuentaDestino = obtenerCuentaPorNumero(connection, numeroCuentaDestino);

        // Verificar si se encontró la cuenta de destino
        if (cuentaDestino == null) {
            System.out.println("La cuenta de destino no existe.");
            return;
        }

        // Realizar el depósito en la cuenta de destino
        cuentaDestino.depositar(connection, monto);

        System.out.println("Transferencia exitosa de " + monto + " de la cuenta " + getNumero() +
                " a la cuenta " + cuentaDestino.getNumero());
    }
}


