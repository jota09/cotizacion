/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Jesus.Ramos
 */
public class Conectar {

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null) {
// con esto determinamos cuando finalize el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                ResourceBundle rb = ResourceBundle.getBundle("configuracion.configjdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pass");
                String usr = rb.getString("user");
                Class.forName(driver);
                System.out.println("Se ha levantado los drivers satisfactoriamente");
                con = DriverManager.getConnection(url, usr, pwd);
                System.out.println("Se ha establecido la conexion  satisfactoriamente");
            }
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Error al crear la conexion", ex);
        }
    }

    static class MiShDwnHook extends Thread {
// justo antes de finalizar el programa la JVM invocara
// a este metodo donde podemos cerrar la conexion

        @Override
        public void run() {
            try {
                Connection con = Conectar.getConnection();
                con.close();
                System.out.println("Cerrando la conexion");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
