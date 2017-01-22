/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import dto.UsuarioDTO;
import facade.Facade;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ConectarConfig {

    // definimos la variable de retorno
    private static final Facade facade = new Facade();
    private static final ArrayList<UsuarioDTO> usuarios = facade.obtenerUsuarios();
    private static UsuarioDTO u = new UsuarioDTO();

    public static UsuarioDTO login(String usrname, String password) {

        try {
            for (UsuarioDTO dto : usuarios) {
                System.out.println(dto.getUser() + " igual a " + usrname + "\n" + dto.getPass() + " igual a " + password);
                if (dto.getUser().equals(usrname)) {
                    if (dto.getPass().equals(password)) {
                        u = dto;
                        u.setValidoUser(true);
                        u.setValidoPass(true);
                        return u;
                    } else {
                        u.setValidoPass(false);
                    }

                } else {
                    u.setValidoUser(false);
                }
            }

        } catch (Exception ex) {
// cualquier error "salgo por excepcion"
            throw new RuntimeException("Error verificando datos", ex);
        }
        return u;
    }

    public static UsuarioDTO usuarioLogueado() {
        return u;
    }

}
