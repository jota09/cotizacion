/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jesus.Ramos
 */
public class Login extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/Login.fxml"));
        Scene scene;
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Cotizacion");
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    
    public void close(){
        Stage stage = new Stage();
        stage.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
