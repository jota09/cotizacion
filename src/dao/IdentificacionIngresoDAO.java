/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexionBD.Conectar;
import dto.IdentificacionIngresoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class IdentificacionIngresoDAO {

    public ArrayList<IdentificacionIngresoDTO> obtenerIdentificadoresIngresosActivo() {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Conectar.getConnection();
        String sql = "SELECT ii.id, ii.identificador, ii.descripcion, ii.activo, ii.eliminado "
                + "FROM identificador_ingreso AS ii "
                + "WHERE ii.activo = 1 AND ii.eliminado = 0 "
                + "ORDER BY ii.id DESC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<IdentificacionIngresoDTO> identificacionIngresos = new ArrayList<IdentificacionIngresoDTO>();
            IdentificacionIngresoDTO identificacionIngreso = null;

            while (rs.next()) {
                identificacionIngreso = new IdentificacionIngresoDTO(rs.getInt("id"), rs.getString("identificador"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getBoolean("eliminado"));
                identificacionIngresos.add(identificacionIngreso);
            }
            return identificacionIngresos;
        } catch (SQLException ex) {
            Logger.getLogger(IngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(IngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    public int insertarIdentificadoresIngresosActivo(String identificador, String descripcion) {
        Connection con;
        PreparedStatement ps = null;
        con = Conectar.getConnection();
        String sql = "INSERT INTO cotizacion.identificador_ingreso "
                + "(id , identificador, descripcion, activo, eliminado) "
                + "VALUES ( NULL ,  ? ,  ?,  1,  0)";
        try {
            // seteamos los valores de los parametros
            ps = con.prepareStatement(sql);
        ps.setString(1, identificador);
        ps.setString(2, descripcion);
        int rtdo = ps.executeUpdate();
        if (rtdo == 1) {
            return 1;
        } else {
            throw new RuntimeException("No se pudo insertar la fila");
        }
        } catch (SQLException ex) {
            Logger.getLogger(IdentificacionIngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int modificarIdentificadoresIngresosActivo(int id, String identificador, String descripcion) {
        Connection con;
        PreparedStatement ps = null;
        con = Conectar.getConnection();
        String sql = "UPDATE cotizacion.identificador_ingreso "
                + "SET  identificador =  ?, descripcion =  ? "
                + "WHERE identificador_ingreso.id =?";
        try {
            // seteamos los valores de los parametros
            ps = con.prepareStatement(sql);
        ps.setString(1, identificador);
        ps.setString(2, descripcion);
        ps.setInt(3, id);
        int rtdo = ps.executeUpdate();
        if (rtdo == 1) {
            return 1;
        } else {
            throw new RuntimeException("No se pudo hacer update en la fila");
        }
        } catch (SQLException ex) {
            Logger.getLogger(IdentificacionIngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int eliminarIdentificadoresIngresosActivo(int id) {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conectar.getConnection();
        String sql = "UPDATE cotizacion.identificador_ingreso "
                + "SET  eliminado = 1 "
                + "WHERE identificador_ingreso.id =?";
        try {
            // seteamos los valores de los parametros
            ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int rtdo = ps.executeUpdate();
        if (rtdo == 1) {
            return 1;
        } else {
            throw new RuntimeException("No se pudo hacer update en la fila");
        }
        } catch (SQLException ex) {
            Logger.getLogger(IdentificacionIngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
