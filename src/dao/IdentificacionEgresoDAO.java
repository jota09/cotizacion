/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexionBD.Conectar;
import conexionBD.ConectarConfig;
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
public class IdentificacionEgresoDAO {

    private UsuarioDTO u = ConectarConfig.usuarioLogueado();

    public ArrayList<IdentificacionEgresoDTO> obtenerIdentificadoresEgresosActivo() {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Conectar.getConnection();
        String sql = "SELECT ie.id, ie.identificador, ie.descripcion, ie.activo, ie.eliminado, ie.usuario_id "
                + "FROM identificador_egreso AS ie "
                + "WHERE ie.activo = 1 AND ie.eliminado = 0 "
                + "AND usuario_id='" + u.getId() + "' "
                + "ORDER BY ie.id DESC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<IdentificacionEgresoDTO> identificacionEgresos = new ArrayList<IdentificacionEgresoDTO>();
            IdentificacionEgresoDTO identificacionEgreso = null;

            while (rs.next()) {
                identificacionEgreso = new IdentificacionEgresoDTO(rs.getInt("id"), rs.getString("identificador"), rs.getString("descripcion"), rs.getBoolean("activo"), rs.getBoolean("eliminado"), u);
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

    public int insertarIdentificadoresEgresosActivo(String identificador, String descripcion) {
        Connection con;
        PreparedStatement ps = null;
        con = Conectar.getConnection();
        String sql = "INSERT INTO cotizacion.identificador_egreso "
                + "(id , identificador, descripcion, activo, eliminado, usuario_id) "
                + "VALUES ( NULL ,  ? ,  ?,  1,  0, ?)";
        try {
            // seteamos los valores de los parametros
            ps = con.prepareStatement(sql);
            ps.setString(1, identificador);
            ps.setString(2, descripcion);
            ps.setInt(3, u.getId());
            int rtdo = ps.executeUpdate();
            if (rtdo == 1) {
                return 1;
            } else {
                throw new RuntimeException("No se pudo insertar la fila");
            }
        } catch (SQLException ex) {
            Logger.getLogger(IdentificacionEgresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int modificarIdentificadoresEgresosActivo(int id, String identificador, String descripcion) {
        Connection con;
        PreparedStatement ps = null;
        con = Conectar.getConnection();
        String sql = "UPDATE cotizacion.identificador_egreso "
                + "SET  identificador =  ?, descripcion =  ? "
                + "WHERE identificador_egreso.id =? "
                + "AND usuario_id='" + u.getId() + "'";
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
            Logger.getLogger(IdentificacionEgresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int eliminarIdentificadoresEgresosActivo(int id) {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = Conectar.getConnection();
        String sql = "UPDATE cotizacion.identificador_egreso "
                + "SET  eliminado = 1 "
                + "WHERE identificador_egreso.id =? "
                + "AND usuario_id='" + u.getId() + "'";
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
            Logger.getLogger(IdentificacionEgresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
