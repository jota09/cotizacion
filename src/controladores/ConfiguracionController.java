/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dto.EgresoDTO;
import dto.IdentificacionEgresoDTO;
import dto.IdentificacionIngresoDTO;
import dto.IngresoDTO;
import facade.Facade;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jesus.Ramos
 */
public class ConfiguracionController implements Initializable {

    @FXML
    private Label label_crear_IdentificadorIngreso, label_identificador_IdentificadorIngreso, label_descripcion_IdentificadorIngreso;
    @FXML
    private TextField input_identificador_IdentificadorIngreso;
    @FXML
    private TextArea area_descripcion_IdentificadorIngreso;
    @FXML
    private Button button_crear_IdentificadorIngreso, button_modificar_IdentificadorIngreso, button_eliminar_IdentificadorIngreso;
    @FXML
    private ComboBox buscarIdentificadorIngreso;
    @FXML
    private Label label_crear_IdentificadorEgreso, label_identificador_IdentificadorEgreso, label_descripcion_IdentificadorEgreso;
    @FXML
    private TextField input_identificador_IdentificadorEgreso;
    @FXML
    private TextArea area_descripcion_IdentificadorEgreso;
    @FXML
    private Button button_crear_IdentificadorEgreso, button_modificar_IdentificadorEgreso, button_eliminar_IdentificadorEgreso;
    @FXML
    private ComboBox buscarIdentificadorEgreso;
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

    /**
     * Initializes the controller class.
     */
    @FXML
    private void formularioCrearIdentificadorIngreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para crear un identificador de ingresos...!");
        label_crear_IdentificadorIngreso.setText("Crear identificador de ingresos");
        input_identificador_IdentificadorIngreso.setText("");
        area_descripcion_IdentificadorIngreso.setText("");
        label_crear_IdentificadorIngreso.setVisible(true);
        label_descripcion_IdentificadorIngreso.setVisible(true);
        label_identificador_IdentificadorIngreso.setVisible(true);
        input_identificador_IdentificadorIngreso.setVisible(true);
        input_identificador_IdentificadorIngreso.setDisable(false);
        area_descripcion_IdentificadorIngreso.setVisible(true);
        area_descripcion_IdentificadorIngreso.setDisable(false);
        button_crear_IdentificadorIngreso.setVisible(true);
        buscarIdentificadorIngreso.setVisible(false);
        button_eliminar_IdentificadorIngreso.setVisible(false);
        button_modificar_IdentificadorIngreso.setVisible(false);
    }

    @FXML
    private void formularioEliminarIdentificadorIngreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para eliminar un identificador de ingresos...!");
        label_crear_IdentificadorIngreso.setVisible(false);
        input_identificador_IdentificadorIngreso.setText("");
        area_descripcion_IdentificadorIngreso.setText("");
        label_descripcion_IdentificadorIngreso.setVisible(false);
        label_identificador_IdentificadorIngreso.setVisible(false);
        input_identificador_IdentificadorIngreso.setVisible(false);
        area_descripcion_IdentificadorIngreso.setVisible(false);
        button_crear_IdentificadorIngreso.setVisible(false);
        button_eliminar_IdentificadorIngreso.setVisible(false);
        button_modificar_IdentificadorIngreso.setVisible(false);
        buscarIdentificadorIngreso.setVisible(true);
        buscarIdentificadorIngreso.getSelectionModel().clearSelection();
        buscarIdentificadorIngreso.setValue(null);
        buscarIdentificadorIngreso.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
                    if (dto.getIdentificador().equals(t1)) {
                        button_crear_IdentificadorIngreso.setVisible(false);
                        button_modificar_IdentificadorIngreso.setVisible(false);
                        button_eliminar_IdentificadorIngreso.setVisible(true);
                        label_crear_IdentificadorIngreso.setText("Eliminar identificador de ingresos");
                        label_crear_IdentificadorIngreso.setVisible(true);
                        label_descripcion_IdentificadorIngreso.setVisible(true);
                        label_identificador_IdentificadorIngreso.setVisible(true);
                        input_identificador_IdentificadorIngreso.setVisible(true);
                        input_identificador_IdentificadorIngreso.setDisable(true);
                        area_descripcion_IdentificadorIngreso.setVisible(true);
                        area_descripcion_IdentificadorIngreso.setDisable(true);
                        input_identificador_IdentificadorIngreso.setText(dto.getIdentificador());
                        area_descripcion_IdentificadorIngreso.setText(dto.getDescripcion());
                    }
                }
            }
        });
    }

    @FXML
    private void formularioModificarIdentificadorIngreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para modificar un identificador de ingresos...!");
        label_crear_IdentificadorIngreso.setVisible(false);
        input_identificador_IdentificadorIngreso.setText("");
        area_descripcion_IdentificadorIngreso.setText("");
        label_descripcion_IdentificadorIngreso.setVisible(false);
        label_identificador_IdentificadorIngreso.setVisible(false);
        input_identificador_IdentificadorIngreso.setVisible(false);
        input_identificador_IdentificadorIngreso.setDisable(false);
        area_descripcion_IdentificadorIngreso.setVisible(false);
        area_descripcion_IdentificadorIngreso.setDisable(false);
        button_crear_IdentificadorIngreso.setVisible(false);
        button_eliminar_IdentificadorIngreso.setVisible(false);
        button_modificar_IdentificadorIngreso.setVisible(false);
        buscarIdentificadorIngreso.setVisible(true);
        buscarIdentificadorIngreso.getSelectionModel().clearSelection();
        buscarIdentificadorIngreso.setValue(null);
        buscarIdentificadorIngreso.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
                    if (dto.getIdentificador().equals(t1)) {
                        button_modificar_IdentificadorIngreso.setVisible(true);
                        area_descripcion_IdentificadorIngreso.setDisable(false);
                        input_identificador_IdentificadorIngreso.setDisable(false);
                        button_crear_IdentificadorIngreso.setVisible(false);
                        button_eliminar_IdentificadorIngreso.setVisible(false);
                        label_crear_IdentificadorIngreso.setText("Modificar identificador de ingresos");
                        label_crear_IdentificadorIngreso.setVisible(true);
                        label_descripcion_IdentificadorIngreso.setVisible(true);
                        label_descripcion_IdentificadorIngreso.setVisible(true);
                        label_identificador_IdentificadorIngreso.setVisible(true);
                        input_identificador_IdentificadorIngreso.setVisible(true);
                        area_descripcion_IdentificadorIngreso.setVisible(true);
                        input_identificador_IdentificadorIngreso.setText(dto.getIdentificador());
                        area_descripcion_IdentificadorIngreso.setText(dto.getDescripcion());

                    }
                }
            }
        });
    }
    @FXML
    private void formularioCrearIdentificadorEgreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para crear un identificador de egresos...!");
        label_crear_IdentificadorEgreso.setText("Crear identificador de egresos");
        input_identificador_IdentificadorEgreso.setText("");
        area_descripcion_IdentificadorEgreso.setText("");
        label_crear_IdentificadorEgreso.setVisible(true);
        label_descripcion_IdentificadorEgreso.setVisible(true);
        label_identificador_IdentificadorEgreso.setVisible(true);
        input_identificador_IdentificadorEgreso.setVisible(true);
        input_identificador_IdentificadorEgreso.setDisable(false);
        area_descripcion_IdentificadorEgreso.setVisible(true);
        area_descripcion_IdentificadorEgreso.setDisable(false);
        button_crear_IdentificadorEgreso.setVisible(true);
        buscarIdentificadorEgreso.setVisible(false);
        button_eliminar_IdentificadorEgreso.setVisible(false);
        button_modificar_IdentificadorEgreso.setVisible(false);
    }

    @FXML
    private void formularioEliminarIdentificadorEgreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para eliminar un identificador de egresos...!");
        label_crear_IdentificadorEgreso.setVisible(false);
        input_identificador_IdentificadorEgreso.setText("");
        area_descripcion_IdentificadorEgreso.setText("");
        label_descripcion_IdentificadorEgreso.setVisible(false);
        label_identificador_IdentificadorEgreso.setVisible(false);
        input_identificador_IdentificadorEgreso.setVisible(false);
        area_descripcion_IdentificadorEgreso.setVisible(false);
        button_crear_IdentificadorEgreso.setVisible(false);
        button_eliminar_IdentificadorEgreso.setVisible(false);
        button_modificar_IdentificadorEgreso.setVisible(false);
        buscarIdentificadorEgreso.setVisible(true);
        buscarIdentificadorEgreso.getSelectionModel().clearSelection();
        buscarIdentificadorEgreso.setValue(null);
        buscarIdentificadorEgreso.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
                    if (dto.getIdentificador().equals(t1)) {
                        button_crear_IdentificadorEgreso.setVisible(false);
                        button_modificar_IdentificadorEgreso.setVisible(false);
                        button_eliminar_IdentificadorEgreso.setVisible(true);
                        label_crear_IdentificadorEgreso.setText("Eliminar identificador de egresos");
                        label_crear_IdentificadorEgreso.setVisible(true);
                        label_descripcion_IdentificadorEgreso.setVisible(true);
                        label_identificador_IdentificadorEgreso.setVisible(true);
                        input_identificador_IdentificadorEgreso.setVisible(true);
                        input_identificador_IdentificadorEgreso.setDisable(true);
                        area_descripcion_IdentificadorEgreso.setVisible(true);
                        area_descripcion_IdentificadorEgreso.setDisable(true);
                        input_identificador_IdentificadorEgreso.setText(dto.getIdentificador());
                        area_descripcion_IdentificadorEgreso.setText(dto.getDescripcion());
                    }
                }
            }
        });
    }

    @FXML
    private void formularioModificarIdentificadorEgreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para modificar un identificador de egresos...!");
        label_crear_IdentificadorEgreso.setVisible(false);
        input_identificador_IdentificadorEgreso.setText("");
        area_descripcion_IdentificadorEgreso.setText("");
        label_descripcion_IdentificadorEgreso.setVisible(false);
        label_identificador_IdentificadorEgreso.setVisible(false);
        input_identificador_IdentificadorEgreso.setVisible(false);
        input_identificador_IdentificadorEgreso.setDisable(false);
        area_descripcion_IdentificadorEgreso.setVisible(false);
        area_descripcion_IdentificadorEgreso.setDisable(false);
        button_crear_IdentificadorEgreso.setVisible(false);
        button_eliminar_IdentificadorEgreso.setVisible(false);
        button_modificar_IdentificadorEgreso.setVisible(false);
        buscarIdentificadorEgreso.setVisible(true);
        buscarIdentificadorEgreso.getSelectionModel().clearSelection();
        buscarIdentificadorEgreso.setValue(null);
        buscarIdentificadorEgreso.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
                    if (dto.getIdentificador().equals(t1)) {
                        button_modificar_IdentificadorEgreso.setVisible(true);
                        area_descripcion_IdentificadorEgreso.setDisable(false);
                        input_identificador_IdentificadorEgreso.setDisable(false);
                        button_crear_IdentificadorEgreso.setVisible(false);
                        button_eliminar_IdentificadorEgreso.setVisible(false);
                        label_crear_IdentificadorEgreso.setText("Modificar identificador de egresos");
                        label_crear_IdentificadorEgreso.setVisible(true);
                        label_descripcion_IdentificadorEgreso.setVisible(true);
                        label_descripcion_IdentificadorEgreso.setVisible(true);
                        label_identificador_IdentificadorEgreso.setVisible(true);
                        input_identificador_IdentificadorEgreso.setVisible(true);
                        area_descripcion_IdentificadorEgreso.setVisible(true);
                        input_identificador_IdentificadorEgreso.setText(dto.getIdentificador());
                        area_descripcion_IdentificadorEgreso.setText(dto.getDescripcion());

                    }
                }
            }
        });
    }
    
    @FXML
    private void cerrarPrograma() throws Exception {
        Stage stage = (Stage) buscarIdentificadorIngreso.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void crearIdentificadorIngreso() throws Exception {
        int crear = facade.insertarIdentificadoresIngresosActivo(input_identificador_IdentificadorIngreso.getText(), area_descripcion_IdentificadorIngreso.getText());
        if(crear == 1){
            input_identificador_IdentificadorIngreso.setText("");
            area_descripcion_IdentificadorIngreso.setText("");
            System.out.println("ha sido creado exitosamente");
        }
    }
    
    @FXML
    private void modificarIdentificadorIngreso() throws Exception {
        Stage stage = (Stage) buscarIdentificadorIngreso.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void eliminarIdentificadorIngreso() throws Exception {
        Stage stage = (Stage) buscarIdentificadorIngreso.getScene().getWindow();
        stage.close();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
            buscarIdentificadorIngreso.getItems().addAll(dto.getIdentificador());
        }
        buscarIdentificadorIngreso.setEditable(true);
        for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
            buscarIdentificadorEgreso.getItems().addAll(dto.getIdentificador());
        }
        buscarIdentificadorEgreso.setEditable(true);
    }

}
