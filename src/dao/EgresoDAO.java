/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexionBD.Conectar;
import conexionBD.ConectarConfig;
import dto.EgresoDTO;
import dto.IdentificacionEgresoDTO;
import dto.UsuarioDTO;
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
public class EgresoDAO {
    private UsuarioDTO u = ConectarConfig.usuarioLogueado();
    
    public ArrayList<EgresoDTO> obtenerEgresosActivo() {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Conectar.getConnection();
        String sql = "SELECT e.id, ie.id AS idIden, ie.identificador, e.nombre, e.valor, e.descripcion, e.fecha_inicio, e.fecha_fin, e.activo, e.eliminado, e.usuario_id "
                + "FROM egreso AS e "
                + "JOIN identificador_egreso AS ie ON e.identificador = ie.id "
                + "WHERE e.activo = 1 AND e.eliminado = 0 AND ie.activo = 1 AND ie.eliminado = 0 "
                + "AND e.usuario_id='"+u.getId()+"' AND ie.usuario_id='"+u.getId()+"' "
                + "ORDER BY e.valor DESC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<EgresoDTO> egresos = new ArrayList<EgresoDTO>();
            EgresoDTO egreso = null;

            while (rs.next()) {
                egreso = new EgresoDTO(rs.getInt("id"), new IdentificacionEgresoDTO(rs.getInt("idIden"),rs.getString("identificador")), rs.getString("nombre"), rs.getInt("valor"), rs.getString("descripcion"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getBoolean("activo"), rs.getBoolean("eliminado"), u);
                egresos.add(egreso);
            }
            return egresos;
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
