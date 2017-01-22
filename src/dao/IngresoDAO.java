/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexionBD.Conectar;
import conexionBD.ConectarConfig;
import dto.IngresoDTO;
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
public class IngresoDAO {
    private UsuarioDTO u = ConectarConfig.usuarioLogueado();

    public ArrayList<IngresoDTO> obtenerIngresosActivo() {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Conectar.getConnection();
        String sql = "SELECT i.id, ii.identificador, i.nombre, i.valor, i.descripcion, i.fecha_inicio, i.fecha_fin, i.activo, i.eliminado, i.usuario_id "
                + "FROM ingreso AS i "
                + "JOIN identificador_ingreso AS ii ON i.identificador = ii.id "
                + "WHERE i.activo = 1 AND i.eliminado = 0 AND ii.activo = 1 AND ii.eliminado = 0 "
                + "AND i.usuario_id='"+u.getId()+"' AND ii.usuario_id='"+u.getId()+"' "
                + "ORDER BY i.valor DESC";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<IngresoDTO> ingresos = new ArrayList<IngresoDTO>();
            IngresoDTO ingreso = null;

            while (rs.next()) {
                ingreso = new IngresoDTO(rs.getInt("id"), rs.getString("identificador"), rs.getString("nombre"), rs.getInt("valor"), rs.getString("descripcion"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getBoolean("activo"), rs.getBoolean("eliminado"), rs.getInt("usuario_id"));
                ingresos.add(ingreso);
            }
            return ingresos;
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
    
    public int insertarIngresosActivo(String identificador, String descripcion) {
        Connection con;
        PreparedStatement ps = null;
        con = Conectar.getConnection();
        String sql = "INSERT INTO cotizacion.identificador_ingreso "
                + "(id , identificador, descripcion, activo, eliminado,usuario_id) "
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
            Logger.getLogger(IdentificacionIngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
