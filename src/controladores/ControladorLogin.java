/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import conexionBD.ConectarConfig;
import dto.UsuarioDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Jesus.Ramos
 */
public class ControladorLogin implements Initializable {

    @FXML
    private ProgressIndicator progres1;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField user;
    @FXML
    private UsuarioDTO u = null;
    @FXML
    private Label validaUser;
    @FXML
    private Label validaPass;
    @FXML
    private Button buttonLogin;

    @FXML
    private void ingresarSistema(ActionEvent event) {
        System.out.println("Logueando!");
        progres1.setVisible(true);
        u = ConectarConfig.login(user.getText(), pass.getText());
        if (u.getValidoUser() && u.getValidoPass()) {
            System.out.println("Logueo Satisfactorio!!");
            validaUser.setVisible(false);
            validaPass.setVisible(false);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            progres1.setVisible(false);
            try {
                cerrarPrograma();
                inicio();
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (!u.getValidoPass()) {
                System.out.println("El password no coincide");
                validaPass.setVisible(true);
                progres1.setVisible(false);
                pass.setText("");
                if (!u.getValidoUser()) {
                    System.out.println("El usuario no se encuentra");
                    user.setText("");
                    validaUser.setVisible(true);
                    validaPass.setVisible(false);
                    progres1.setVisible(false);
                } else {
                    validaUser.setVisible(false);
                }
            } else {
                validaPass.setVisible(false);
            }
        }
    }

    @FXML
    private void acercaDe(ActionEvent event) throws IOException {
        System.out.println("Abriendo otra ventana con el Acerca...!");
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/Acerca.fxml"));
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Acerca de");
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void inicio() throws IOException {
        System.out.println("Abriendo la ventana de inicio...!");
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/Inicio.fxml"));
        System.out.println("Entra aqui...!");
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void cerrarPrograma() throws Exception {
        Stage stage = (Stage) buttonLogin.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void limpiar() throws Exception {
        System.out.println("Limpiando campos");
        pass.setText("");
        validaPass.setVisible(false);
        user.setText("");
        validaUser.setVisible(false);
        progres1.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
