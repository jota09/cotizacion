/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus.Ramos
 */
public class Conectar {
    private static String user = "sa";
    private static String pass = "";
    private static String driver = "org.hsqldb.jdbcDriver";
    private static String url = "jdbc:hsqldb:hsql://localhost/xdb";
    
    private static Connection con = null;
    public static Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("url de BD", user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
