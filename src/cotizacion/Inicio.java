/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizacion;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jesus.Ramos
 */
public class Inicio extends Application {
    
    @Override
    public void start(Stage secondaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/Inicio.fxml"));
        
        Scene scene;
        scene = new Scene(root);
        secondaryStage.setScene(scene);
        secondaryStage.setTitle("Inicio");
        secondaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
