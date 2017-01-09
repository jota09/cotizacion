/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import conexionBD.Conectar;
import conexionBD.ConectarConfig;
import cotizacion.Usuario;
import dao.EgresoDAO;
import dao.IngresoDAO;
import dto.EgresoDTO;
import dto.IngresoDTO;
import facade.Facade;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
    private Label TtotalIngreso;
    @FXML
    private Label TtotalEgreso;
    @FXML
    private Label Ttotal;
    @FXML
    private Label TmayorIngreso;
    @FXML
    private Label TmayorEgreso;
    @FXML
    private Image indicadorBalance;
    @FXML
    private ComboBox idenIngreso;
    @FXML
    private Connection con = null;
    @FXML
    private Facade facade = new Facade();
    @FXML
    private ArrayList<IngresoDTO> colIngreso = facade.obtenerIngresosActivo();
    @FXML
    private ArrayList<EgresoDTO> colEgreso = facade.obtenerEgresosActivo();
    @FXML
    private int totalEgreso = 0;
    @FXML
    private int totalIngreso = 0;

    @FXML
    private void mostrarUser() throws Exception {
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
    private void cerrarPrograma() throws Exception {
        Stage stage = (Stage) nombreUsuario.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nombreUsuario.setText(u.getName());
        System.out.println(u.toString());
        con = Conectar.getConnection();
        for (IngresoDTO dto : colIngreso) {
            totalIngreso += dto.getValor();
            System.out.println(dto);
        }
        for (EgresoDTO dto : colEgreso) {
            totalEgreso += dto.getValor();
            System.out.println(dto);
        }
        if (totalIngreso > 0) {
            TtotalIngreso.setText(totalIngreso + "$");
        } else {
            TtotalIngreso.setText("0$");
        }
        if (totalEgreso > 0) {
            TtotalEgreso.setText(totalEgreso + "$");
        } else {
            TtotalEgreso.setText("0$");
        }
        if ((totalIngreso - totalEgreso) >= 0) {
            Ttotal.setText((totalIngreso - totalEgreso) + "$");
        } else {
            Ttotal.setText("-" + (totalEgreso - totalIngreso) + "$");
        }
        if (colIngreso.size() > 0) {
            IngresoDTO dto = colIngreso.get(0);
            TmayorIngreso.setText(dto.toString());
        } else {
            TmayorIngreso.setText("Sin Ingreso");
        }
        if (colEgreso.size() > 0) {
            EgresoDTO dto = colEgreso.get(0);
            TmayorEgreso.setText(dto.toString());
        } else {
            TmayorEgreso.setText("Sin Egreso");
        }

    }

}