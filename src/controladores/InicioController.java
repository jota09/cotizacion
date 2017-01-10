/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import conexionBD.Conectar;
import conexionBD.ConectarConfig;
import cotizacion.Usuario;
import dto.EgresoDTO;
import dto.IdentificacionEgresoDTO;
import dto.IdentificacionIngresoDTO;
import dto.IngresoDTO;
import facade.Facade;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
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
    private Label labelIden;
    @FXML
    private Label labelDes;
    @FXML
    private ComboBox idenIngreso;
    @FXML
    private ComboBox idenEgreso;
    @FXML
    private TitledPane panel1, panel2, panel3;
    @FXML
    private Connection con = null;
    @FXML
    private Facade facade = new Facade();
    @FXML
    private ArrayList<IngresoDTO> colIngreso = facade.obtenerIngresosActivo();
    @FXML
    private ArrayList<EgresoDTO> colEgreso = facade.obtenerEgresosActivo();
    @FXML
    private ArrayList<IdentificacionIngresoDTO> colIdentificadorIngreso = facade.obtenerIdentificacionIngresosActivo();
    @FXML
    private ArrayList<IdentificacionEgresoDTO> colIdentificadorEgreso = facade.obtenerIdentificacionEgresosActivo();
    @FXML
    private int totalEgreso = 0;
    @FXML
    private int totalIngreso = 0;
    @FXML
    DecimalFormat formateador = new DecimalFormat("###,###.##");

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
    private void configuracion(ActionEvent event) throws IOException {
        System.out.println("Abriendo otra ventana con las configuraciones...!");
        Parent root = FXMLLoader.load(getClass().getResource("/vistas/Configuracion.fxml"));
        Stage stage = new Stage();
        Scene scene;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Configuracion");
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void borrado(ActionEvent event) throws IOException {
        System.out.println("Limpiando la ventana de inicio...!");
        idenIngreso.getSelectionModel().clearSelection();
        idenIngreso.setValue(null);
        idenEgreso.getSelectionModel().clearSelection();
        idenEgreso.setValue(null);
        panel1.setExpanded(false);
        panel2.setExpanded(false);
        panel3.setExpanded(false);
        labelIden.setText("");
        labelDes.setText("");

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
        con = Conectar.getConnection();
        for (IngresoDTO dto : colIngreso) {
            totalIngreso += dto.getValor();
        }
        for (EgresoDTO dto : colEgreso) {
            totalEgreso += dto.getValor();
        }
        if (totalIngreso > 0) {
            TtotalIngreso.setText(formateador.format(totalIngreso) + "$");
        } else {
            TtotalIngreso.setText("0$");
        }
        if (totalEgreso > 0) {
            TtotalEgreso.setText(formateador.format(totalEgreso) + "$");
        } else {
            TtotalEgreso.setText("0$");
        }
        if ((totalIngreso - totalEgreso) >= 0) {
            Ttotal.setText(formateador.format(totalIngreso - totalEgreso) + "$");
        } else {
            Ttotal.setText("-" + formateador.format(totalIngreso - totalEgreso) + "$");
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
        for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
            idenIngreso.getItems().addAll(dto.getIdentificador());
        }
        for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
            idenEgreso.getItems().addAll(dto.getIdentificador());
        }
        idenIngreso.setEditable(true);
        idenIngreso.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
                    if (dto.getIdentificador().equals(t1)) {
                        String id = "" + dto.getId() + "";
                        labelIden.setText(dto.getIdentificador());
                        labelIden.setAlignment(Pos.CENTER);
                        labelDes.setText(dto.getDescripcion());
                        labelDes.setAlignment(Pos.CENTER);
                        idenEgreso.getSelectionModel().clearSelection();
                        idenEgreso.setValue(null);
                    }
                }
            }
        });
        idenEgreso.setEditable(true);
        idenEgreso.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
                    if (dto.getIdentificador().equals(t1)) {
                        String id = "" + dto.getId() + "";
                        labelIden.setText(dto.getIdentificador());
                        labelIden.setAlignment(Pos.CENTER);
                        labelDes.setText(dto.getDescripcion());
                        labelDes.setAlignment(Pos.CENTER);
                        idenIngreso.getSelectionModel().clearSelection();
                        idenIngreso.setValue(null);
                    }
                }
            }
        });

    }

}
