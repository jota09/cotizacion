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
public class ConfiguracionEgresoController implements Initializable {

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
    private ArrayList<EgresoDTO> colEgreso = facade.obtenerEgresosActivo();
    @FXML
    private ArrayList<IdentificacionEgresoDTO> colIdentificadorEgreso = facade.obtenerIdentificacionEgresosActivo();
    @FXML
    private int id_facade;

    /**
     * Initializes the controller class.
     */
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
                        id_facade = dto.getId();
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
                        id_facade = dto.getId();
                        input_identificador_IdentificadorEgreso.setText(dto.getIdentificador());
                        area_descripcion_IdentificadorEgreso.setText(dto.getDescripcion());

                    }
                }
            }
        });
    }

    @FXML
    private void cerrarPrograma() throws Exception {
        Stage stage = (Stage) buscarIdentificadorEgreso.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void crearIdentificadorEgreso() throws Exception {
        int crear = facade.insertarIdentificadoresEgresosActivo(input_identificador_IdentificadorEgreso.getText(), area_descripcion_IdentificadorEgreso.getText());
        if (crear == 1) {
            input_identificador_IdentificadorEgreso.setText("");
            area_descripcion_IdentificadorEgreso.setText("");
            System.out.println("Ha sido creado exitosamente");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/RegistroExitoso.fxml"));
            Stage stage = new Stage();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Satisfactorio");
            stage.show();
            stage.setResizable(false);
            colIdentificadorEgreso = facade.obtenerIdentificacionEgresosActivo();
            buscarIdentificadorEgreso.getItems().clear();
            for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
                buscarIdentificadorEgreso.getItems().addAll(dto.getIdentificador());
            }
        } else {
            System.out.println("No ha podido ser creado");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/RegistroFallido.fxml"));
            Stage stage = new Stage();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ERROR");
            stage.show();
            stage.setResizable(false);
        }
    }

    @FXML
    private void modificarIdentificadorEgreso() throws Exception {
        int modificar = facade.modificarIdentificadoresEgresosActivo(id_facade, input_identificador_IdentificadorEgreso.getText(), area_descripcion_IdentificadorEgreso.getText());
        if (modificar == 1) {
            System.out.println("Ha sido modificado exitosamente");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/RegistroExitoso.fxml"));
            Stage stage = new Stage();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Satisfactorio");
            stage.show();
            stage.setResizable(false);
            colIdentificadorEgreso = facade.obtenerIdentificacionEgresosActivo();
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
        } else {
            input_identificador_IdentificadorEgreso.setText("");
            area_descripcion_IdentificadorEgreso.setText("");
            System.out.println("No ha podido ser modificado");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/RegistroFallido.fxml"));
            Stage stage = new Stage();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ERROR");
            stage.show();
            stage.setResizable(false);
        }
    }

    @FXML
    private void eliminarIdentificadorEgreso() throws Exception {
        int eliminar = facade.eliminarIdentificadoresEgresosActivo(id_facade);
        if (eliminar == 1) {
            System.out.println("Ha sido eliminado exitosamente");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/RegistroExitoso.fxml"));
            Stage stage = new Stage();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Satisfactorio");
            stage.show();
            stage.setResizable(false);
            colIdentificadorEgreso = facade.obtenerIdentificacionEgresosActivo();
            buscarIdentificadorEgreso.getItems().clear();
            for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
                buscarIdentificadorEgreso.getItems().addAll(dto.getIdentificador());
            }
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
        } else {
            input_identificador_IdentificadorEgreso.setText("");
            area_descripcion_IdentificadorEgreso.setText("");
            System.out.println("No ha podido ser eliminado");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/RegistroFallido.fxml"));
            Stage stage = new Stage();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ERROR");
            stage.show();
            stage.setResizable(false);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
            buscarIdentificadorEgreso.getItems().addAll(dto.getIdentificador());
        }
        buscarIdentificadorEgreso.setEditable(true);
    }

}
