/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import cotizacion.Usuario;
import java.util.ResourceBundle;

/**
 *
 * @author root
 */
public class ConectarConfig {

    public Usuario login(String usrname, String password) {

        try {
// leemos el archivo de propiedades que debe estar ubicado
// en el package configuracion
            ResourceBundle rb = ResourceBundle.getBundle("configuracion/config");
// leemos el valor de la propiedad usrname
            String usr = rb.getString("usrname");
// leemos el valor de la propiedad password
            String pwd = rb.getString("password");
// defi nimos la variable de retorno
            Usuario u = null;
// si coinciden los datos proporcionados con los leidos
            if (usr.equals(usrname) && pwd.equals(password)) {
// instancio y seteo todos los datos
            }
            u = new Usuario();
            u.setUser(usr);
            u.setPass(pwd);
            u.setName(rb.getString("name"));
// retorno la instancia o null si no entro al if
            return u;
        } catch (Exception ex) {
// cualquier error "salgo por excepcion"
            throw new RuntimeException("Error verifi cando datos", ex);
        }
    }

}
