package com.mycompany.crudfuncionarios.dao;

import com.mycompany.crudfuncionarios.dominio.Funcionarios;
import com.mycompany.crudfuncionarios.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosDao {

    private static final String GET_FUNCIONARIOS = "select * from funcionarios";

    private static final String CREATE_FUNCIONARIO = "insert into funcionarios"
            + "(tipoId, identificacion, nombre, apellido, estadoCivil, sexo, direccion, telefono,fechaNac)"
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios where id = ?";

    private static final String UPDATE_FUNCIONARIO = "update car set tipoId=?,identificacion=?,nombre=?, apellido=?"
            + "estadoCivil=?, sexo=?, direccion=?, telefono=?,fechaNac=? where id=?";

    private static final String DELETE_FUNCIONARIOS = "delete from funcionarios where id=?";

    //Metodos
    //Crear
    public void crear(Funcionarios funcionarios) throws SQLException {

        //Conectar a la BD
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO); //preparar consulta y envia por parametro
            preparedStatement.setString(1, funcionarios.getTipoId());
            preparedStatement.setString(2, funcionarios.getIdentificacion());
            preparedStatement.setString(3, funcionarios.getNombre());
            preparedStatement.setString(4, funcionarios.getApellido());
            preparedStatement.setString(5, funcionarios.getEstadoCivil());
            preparedStatement.setString(6, funcionarios.getSexo());
            preparedStatement.setString(7, funcionarios.getDireccion());
            preparedStatement.setString(8, funcionarios.getTelefono());
            preparedStatement.setString(9, funcionarios.getFechaNac());
            preparedStatement.executeUpdate(); //?

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    //Listar funcionarios
    public List<Funcionarios> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionarios> funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS); //solicita consulta
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Funcionarios funcionario = new Funcionarios(); //sin s
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setIdentificacion("identificacion");
                funcionario.setNombre("Nombre");
                funcionario.setApellido("Apellido");
                funcionario.setEstadoCivil("Esdado Civil");
                funcionario.setSexo("Sexo");
                funcionario.setDireccion("Direccion");
                funcionario.setTelefono("Telefono");
                funcionario.setFechaNac("Fecha de Nacimiento");
                funcionarios.add(funcionario);
            }
            return funcionarios;

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }

        }
    }

    //Obtener funcionario
    public Funcionarios obtenerFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionarios funcionario = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionarios();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setIdentificacion("identificacion");
                funcionario.setNombre("Nombre");
                funcionario.setApellido("Apellido");
                funcionario.setEstadoCivil("Esdado Civil");
                funcionario.setSexo("Sexo");
                funcionario.setDireccion("Direccion");
                funcionario.setTelefono("Telefono");
                funcionario.setFechaNac("Fecha de Nacimiento");
            }
            return funcionario;

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    //Actualizar
    public void actualizarFuncionario(int id, Funcionarios funcionarios) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionarios.getTipoId());
            preparedStatement.setString(2, funcionarios.getIdentificacion());
            preparedStatement.setString(3, funcionarios.getNombre());
            preparedStatement.setString(4, funcionarios.getApellido());
            preparedStatement.setString(5, funcionarios.getEstadoCivil());
            preparedStatement.setString(6, funcionarios.getSexo());
            preparedStatement.setString(7, funcionarios.getDireccion());
            preparedStatement.setString(8, funcionarios.getTelefono());
            preparedStatement.setString(9, funcionarios.getFechaNac());
            preparedStatement.executeLargeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    //Eliminar

    public void eliminarFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIOS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close(); 
            }
        }
    }
}
