/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static com.sun.glass.ui.Cursor.setVisible;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

/**
 *
 * @author Jesus.Ramos
 */
public class ControladorLogin implements Initializable {

    @FXML
    private ProgressIndicator progres1;

    @FXML
    private void ingresarSistema(ActionEvent event) {
        System.out.println("Logueando!");
        progres1.setVisible(true);
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
    private void cerrarPrograma(ActionEvent event) throws Exception {
        System.out.println("oculto...");
        setVisible(false);
        System.out.println("Bye bye...");
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
