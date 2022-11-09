package com.mycompany.crudfuncionarios.controller;

import com.mycompany.crudfuncionarios.dao.FuncionariosDao;
import com.mycompany.crudfuncionarios.dominio.Funcionarios;
import java.sql.SQLException;
import java.util.List;

public class FuncionariosController {

    private FuncionariosDao funcionariosDao; //clase-nombre

    public FuncionariosController() {
        funcionariosDao = new FuncionariosDao(); //Llamado de todo el metodo
    }

    public void crear(Funcionarios funcionarios) throws SQLException {
        funcionariosDao.crear(funcionarios);
    }

    public List<Funcionarios> obtenerFuncionarios() throws SQLException {
        return funcionariosDao.obtenerFuncionarios();
    }

    public Funcionarios obtenerFuncionario(int id) throws SQLException {

        return funcionariosDao.obtenerFuncionario(id);
    }
    
    public void actualizarFuncionario(int id, Funcionarios funcionarios) throws SQLException {
        funcionariosDao.actualizarFuncionario(id, funcionarios);
    }
    
    public void eliminarFuncionario(int id) throws SQLException {
        funcionariosDao.eliminarFuncionario(id);
    }
}


