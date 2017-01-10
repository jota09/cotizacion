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
}
