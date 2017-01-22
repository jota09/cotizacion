/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexionBD.Conectar;
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
public class UsuarioDAO {

    public ArrayList<UsuarioDTO> obtenerUsuariosActivos() {
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Conectar.getConnection();
        String sql = "select * from usuario where eliminado = 0;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
            UsuarioDTO usuario = null;

            while (rs.next()) {
                usuario = new UsuarioDTO(rs.getInt("id"), rs.getString("user"), rs.getString("nombre"), rs.getString("pass"), rs.getInt("meta"), rs.getBoolean("activo"), rs.getBoolean("eliminado"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }
}

