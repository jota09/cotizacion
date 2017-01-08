/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import conexionBD.Conectar;
import conexionBD.ConectarConfig;
import cotizacion.Usuario;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Jesus.Ramos
 */
public class InicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Usuario u = ConectarConfig.usuarioLogueado();
    @FXML
    private Label nombreUsuario;
    @FXML
    private Connection con = null;
    
    @FXML
    private void mostrarUser() throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Entro aqui");
        nombreUsuario.setText(u.getName());
        System.out.println(u.toString());
        con = Conectar.getConnection();        

    }    
    
}
