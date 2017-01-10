/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexionBD.Conectar;
import dto.IdentificacionEgresoDTO;
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
public class IdentificacionEgresoDAO {
    public ArrayList<IdentificacionEgresoDTO> obtenerIdentificadoresEgresosActivo() {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Conectar.getConnection();
        String sql = "SELECT ie.id, ie.identificador, ie.descripcion, ie.activo, ie.eliminado "
                + "FROM identificador_egreso AS ie "
                + "WHERE ie.activo = 1 AND ie.eliminado = 0 "
                + "ORDER BY ie.id DESC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<IdentificacionEgresoDTO> identificacionEgresos = new ArrayList<IdentificacionEgresoDTO>();
            IdentificacionEgresoDTO identificacionEgreso = null;

            while (rs.next()) {
                identificacionEgreso = new IdentificacionEgresoDTO(rs.getInt("id"), rs.getString("identificador"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getBoolean("eliminado"));
                identificacionEgresos.add(identificacionEgreso);
            }
            return identificacionEgresos;
        } catch (SQLException ex) {
            Logger.getLogger(EgresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EgresoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }
}
