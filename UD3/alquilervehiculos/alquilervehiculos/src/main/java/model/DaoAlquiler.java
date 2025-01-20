package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAlquiler {
    String url = "jdbc:mysql://localhost:3306/testdb"; // Replace `testdb` with your database name
    Connection connection = null;

    public DaoAlquiler(String url) throws SQLException {
        this.url = url;
        this.connection = DriverManager.getConnection(url);
    }

    public void insertCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO clientes (nombre, apellido, numeroLicencia, dni, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cliente.getNombre());
        preparedStatement.setString(2, cliente.getApellido());
        preparedStatement.setString(3, cliente.getNumeroLicencia());
        preparedStatement.setString(4, cliente.getDni());
        preparedStatement.setString(5, cliente.getDireccion());
        preparedStatement.setString(6, cliente.getTelefono());
        preparedStatement.executeUpdate();

    }
    public void insertAlquiler(Alquiler alquiler) throws SQLException {
        String query = "INSERT INTO alquiler (fechaInicio, fechaTope, kilometrajeInicial, kilometrajeFinal, Idcliente, Idvehiculo) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDate(1, alquiler.getFechaInicio());
        preparedStatement.setDate(2,  alquiler.getFechaTope());
        preparedStatement.setInt(3, alquiler.getKilometrajeInicial());
        preparedStatement.setInt(4, alquiler.getKilometrajeFinal());
        preparedStatement.setInt(5, alquiler.getCliente().getIdCliente());
        preparedStatement.setInt(6, alquiler.getVehiculo().getIdVehiculo());
        preparedStatement.executeUpdate();

    }
    public void insertIncidente(Incidente incidente) throws SQLException {
        String query = "INSERT INTO incidente (daño, costes, fecha, Idalquiler) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, incidente.getDano());
        preparedStatement.setDouble(2, incidente.getCostes());
        preparedStatement.setDate(3, incidente.getFecha());
        preparedStatement.setInt(4, incidente.getAlquiler().getIdAlquiler());
        preparedStatement.executeUpdate();

    }
    public void insertVehiculo(Vehiculo vehiculo) throws SQLException {
        String query = "INSERT INTO vehiculos (, matricula, marca, modelo, ano, estado) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, vehiculo.getMatricula());
        preparedStatement.setString(2, vehiculo.getMarca());
        preparedStatement.setString(3, vehiculo.getModelo());
        preparedStatement.setInt(4, vehiculo.getAnoFabricacion());
        preparedStatement.setString(5, vehiculo.getEstado().toString());
        preparedStatement.executeUpdate();
    }

    public List<Cliente> listClientes() throws SQLException {
        String query = "SELECT * FROM clientes";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente(
                    resultSet.getInt("Idcliente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("numeroLicencia"),
                    resultSet.getString("Dni"),
                    resultSet.getString("direccion"),
                    resultSet.getString("telefono")
            );
            clientes.add(cliente);
        }
        return clientes;

    }

    public List<Alquiler> listAlquileres() throws SQLException {
        String query = "SELECT * FROM alquiler";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Alquiler> alquileres = new ArrayList<>();
        while (resultSet.next()) {
            Alquiler alquiler = new Alquiler(
                    resultSet.getInt("Idalquiler"),
                    java.sql.Date.valueOf(resultSet.getString("fechaInicio")),
                    java.sql.Date.valueOf(resultSet.getString("fechaTope")),
                    resultSet.getInt("kilometrajeInicial"),
                    resultSet.getInt("kilometrajeFinal"),
                    getByIdCliente(resultSet.getInt("Idcliente")),
                   getByIdVehiculo(resultSet.getInt("Idvehiculo"))
            );
            alquileres.add(alquiler);
        }
        return alquileres;
    }

    public List<Incidente> listIncidentes() throws SQLException {
        String query = "SELECT * FROM incidente";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Incidente> incidentes = new ArrayList<>();
        while (resultSet.next()) {
            Incidente incidente = new Incidente(
                    resultSet.getInt("Idincidente"),
                    resultSet.getString("daño"),
                    resultSet.getInt("costes"),
                    java.sql.Date.valueOf(resultSet.getString("fecha")),
                    getByIdAlquiler(resultSet.getInt("Idalquiler"))
            );
            incidentes.add(incidente);
        }
        return incidentes;
    }

    public List<Vehiculo> listVehiculos() throws SQLException {
        String query = "SELECT * FROM vehiculos";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Vehiculo> vehiculos = new ArrayList<>();
        while (resultSet.next()) {
            Vehiculo vehiculo = new Vehiculo(
                    resultSet.getInt("Idvehiculo"),
                    resultSet.getString("matricula"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getInt("anoFabricacion"),
                    resultSet.getString("estado")

            );
            vehiculos.add(vehiculo);
        }
        return vehiculos;
    }

    public void deleteCliente(int idCliente) throws SQLException {
        String query = "DELETE FROM clientes WHERE Idcliente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idCliente);
        preparedStatement.executeUpdate();
    }

    public void deleteAlquiler(int idAlquiler) throws SQLException {
        String query = "DELETE FROM alquiler WHERE Idalquiler = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idAlquiler);
        preparedStatement.executeUpdate();
    }

    public void deleteIncidente(int idIncidente) throws SQLException {
        String query = "DELETE FROM incidente WHERE Idincidente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idIncidente);
        preparedStatement.executeUpdate();
    }

    public void deleteVehiculo(int idVehiculo) throws SQLException {
        String query = "DELETE FROM vehiculos WHERE Idvehiculo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idVehiculo);
        preparedStatement.executeUpdate();
    }

    public void updateCliente(Cliente cliente) throws SQLException {
        String query = "UPDATE clientes SET nombre = ?, apellido = ?, numeroLicencia = ?, dni = ?, direccion = ?, telefono = ? WHERE Idcliente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cliente.getNombre());
        preparedStatement.setString(2, cliente.getApellido());
        preparedStatement.setString(3, cliente.getNumeroLicencia());
        preparedStatement.setString(4, cliente.getDni());
        preparedStatement.setString(5, cliente.getDireccion());
        preparedStatement.setString(6, cliente.getTelefono());
        preparedStatement.setInt(7, cliente.getIdCliente());
        preparedStatement.executeUpdate();
    }

    public void updateAlquiler(Alquiler alquiler) throws SQLException {
        String query = "UPDATE alquiler SET fechaInicio = ?, fechaTope = ?, kilometrajeInicial = ?, kilometrajeFinal = ?, Idcliente = ?, Idvehiculo = ? WHERE Idalquiler = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDate(1, alquiler.getFechaInicio());
        preparedStatement.setDate(2, alquiler.getFechaTope());
        preparedStatement.setInt(3, alquiler.getKilometrajeInicial());
        preparedStatement.setInt(4, alquiler.getKilometrajeFinal());
        preparedStatement.setInt(5, alquiler.getCliente().getIdCliente());
        preparedStatement.setInt(6, alquiler.getVehiculo().getIdVehiculo());
        preparedStatement.setInt(7, alquiler.getIdAlquiler());
        preparedStatement.executeUpdate();
    }

    public void updateIncidente(Incidente incidente) throws SQLException {
        String query = "UPDATE incidente SET daño = ?, costes = ?, fecha = ?, Idalquiler = ? WHERE Idincidente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, incidente.getDano());
        preparedStatement.setDouble(2, incidente.getCostes());
        preparedStatement.setDate(3, incidente.getFecha());
        preparedStatement.setInt(4, incidente.getAlquiler().getIdAlquiler());
        preparedStatement.setInt(5, incidente.getIdIncidente());
        preparedStatement.executeUpdate();
    }

    public void updateVehiculo(Vehiculo vehiculo) throws SQLException {
        String query = "UPDATE vehiculos SET matricula = ?, marca = ?, modelo = ?, anoFabricacion = ?, estado = ? WHERE Idvehiculo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, vehiculo.getMatricula());
        preparedStatement.setString(2, vehiculo.getMarca());
        preparedStatement.setString(3, vehiculo.getModelo());
        preparedStatement.setInt(4, vehiculo.getAnoFabricacion());
        preparedStatement.setString(5, vehiculo.getEstado().toString());
        preparedStatement.setInt(6, vehiculo.getIdVehiculo());
        preparedStatement.executeUpdate();
    }

    public Alquiler getByIdAlquiler(int id) throws SQLException {
        String query = "SELECT * FROM alquiler WHERE Idalquiler = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Alquiler(
                    resultSet.getInt("Idalquiler"),
                    java.sql.Date.valueOf(resultSet.getString("fechaInicio")),
                    java.sql.Date.valueOf(resultSet.getString("fechaTope")),
                    resultSet.getInt("kilometrajeInicial"),
                    resultSet.getInt("kilometrajeFinal"),
                    getByIdCliente(resultSet.getInt("Idcliente")),
                    getByIdVehiculo(resultSet.getInt("Idvehiculo"))
            );
        }
        return null;
    }

    public Cliente getByIdCliente(int id) throws SQLException {
        String query = "SELECT * FROM clientes WHERE Idcliente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Cliente(
                    resultSet.getInt("Idcliente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("numeroLicencia"),
                    resultSet.getString("Dni"),
                    resultSet.getString("direccion"),
                    resultSet.getString("telefono")
            );
        }
        return null;
    }

    public Incidente getByIdIncidente(int id) throws SQLException {
        String query = "SELECT * FROM incidente WHERE Idincidente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Incidente(
                    resultSet.getInt("Idincidente"),
                    resultSet.getString("daño"),
                    resultSet.getInt("costes"),
                    java.sql.Date.valueOf(resultSet.getString("fecha")),
                    getByIdAlquiler(resultSet.getInt("Idalquiler"))
            );
        }
        return null;
    }

    public Vehiculo getByIdVehiculo(int id) throws SQLException {
        String query = "SELECT * FROM vehiculos WHERE Idvehiculo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Vehiculo(
                    resultSet.getInt("Idvehiculo"),
                    resultSet.getString("matricula"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getInt("anoFabricacion"),
                    resultSet.getString("estado")

            );
        }
        return null;
    }

}
