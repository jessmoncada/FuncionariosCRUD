
package com.mycompany.crudfuncionarios.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jess
 */
public class ConnectionUtil {
    
    //Variables constantes
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion_funcionarios";
    private static final String USER = "postgres";
    private static final String PASSWORD= "moncada20";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
