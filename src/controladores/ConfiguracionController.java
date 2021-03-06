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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
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
    private Label label_crear_IdentificadorIngreso, label_identificador_IdentificadorIngreso, label_descripcion_IdentificadorIngreso, ingresoIdentificadorLabel, ingresoNombreLabel, ingresoValorLabel, ingresoDescripLabel, ingresoFechaIniLabel, ingresoFechaFinLabel, ingresoHeadLabel;
    @FXML
    private TextField input_identificador_IdentificadorIngreso, ingresoNombreText, ingresoValorText;
    @FXML
    private TextArea area_descripcion_IdentificadorIngreso, ingresoDescripArea;
    @FXML
    private Button button_crear_IdentificadorIngreso, button_modificar_IdentificadorIngreso, button_eliminar_IdentificadorIngreso, ingresoCrear;
    @FXML
    private ComboBox buscarIdentificadorIngreso, ingresoIdentificadorCombo, buscarIngreso;
    @FXML
    private DatePicker ingresoFechaIniDate, ingresoFechaFinDate;
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
    @FXML
    private int id_facade;
    @FXML
    private String formatoBase = "yyyy-MM-dd", formatoFX = "dd/MM/yyyy";

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
                        id_facade = dto.getId();
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
                        id_facade = dto.getId();
                        input_identificador_IdentificadorIngreso.setText(dto.getIdentificador());
                        area_descripcion_IdentificadorIngreso.setText(dto.getDescripcion());

                    }
                }
            }
        });
    }

    @FXML
    private void formularioCrearIngreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para crear un ingresos...!");
        ingresoHeadLabel.setText("Crear un ingreso");
        buscarIngreso.setVisible(false);
        buscarIngreso.getSelectionModel().clearSelection();
        buscarIngreso.setValue(null);
        ingresoNombreText.setText("");
        ingresoValorText.setText("");
        ingresoDescripArea.setText("");
        ingresoIdentificadorCombo.setValue(null);
        ingresoIdentificadorCombo.setVisible(true);
        ingresoNombreText.setVisible(true);
        ingresoValorText.setVisible(true);
        ingresoDescripArea.setVisible(true);
        ingresoFechaIniDate.setValue(null);
        ingresoFechaFinDate.setValue(null);
        ingresoFechaIniDate.setVisible(true);
        ingresoFechaFinDate.setVisible(true);
        ingresoIdentificadorLabel.setVisible(true);
        ingresoNombreLabel.setVisible(true);
        ingresoValorLabel.setVisible(true);
        ingresoDescripLabel.setVisible(true);
        ingresoFechaIniLabel.setVisible(true);
        ingresoFechaFinLabel.setVisible(true);
        ingresoCrear.setVisible(true);

    }

    @FXML
    private void formularioModificarIngreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para crear un ingresos...!");
        ingresoHeadLabel.setText("");
        ingresoNombreText.setText("");
        ingresoValorText.setText("");
        ingresoDescripArea.setText("");
        ingresoIdentificadorCombo.setValue(null);
        ingresoIdentificadorCombo.setVisible(false);
        ingresoNombreText.setVisible(false);
        ingresoValorText.setVisible(false);
        ingresoDescripArea.setVisible(false);
        ingresoFechaIniDate.setValue(null);
        ingresoFechaFinDate.setValue(null);
        ingresoFechaIniDate.setVisible(false);
        ingresoFechaFinDate.setVisible(false);
        ingresoIdentificadorLabel.setVisible(false);
        ingresoNombreLabel.setVisible(false);
        ingresoValorLabel.setVisible(false);
        ingresoDescripLabel.setVisible(false);
        ingresoFechaIniLabel.setVisible(false);
        ingresoFechaFinLabel.setVisible(false);
        ingresoCrear.setVisible(false);
        ingresoIdentificadorCombo.getItems().clear();
        colIngreso = facade.obtenerIngresosActivo();
        buscarIngreso.setVisible(true);
        buscarIngreso.getSelectionModel().clearSelection();
        buscarIngreso.setValue(null);
        ingresoIdentificadorCombo.getSelectionModel().clearSelection();
        ingresoIdentificadorCombo.setValue(null);
        buscarIngreso.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                for (IngresoDTO dto : colIngreso) {
                    ingresoIdentificadorCombo.getItems().addAll(dto.getIdentificador());
                    if (dto.getNombre().equals(t1)) {
                        ingresoHeadLabel.setText("Modificar un ingreso");
                        ingresoNombreText.setText(dto.getNombre());
                        ingresoValorText.setText("" + dto.getValor() + "");
                        ingresoDescripArea.setText(dto.getDescripcion());
                        ingresoIdentificadorCombo.setValue(dto.getIdentificador().getIdentificador());
                        ingresoIdentificadorCombo.setValue(null);
                        ingresoIdentificadorCombo.setVisible(true);

                        ingresoIdentificadorCombo.getSelectionModel().clearSelection();
                        ingresoIdentificadorCombo.setValue(null);
                        ingresoIdentificadorCombo.valueProperty().addListener(new ChangeListener<String>() {
                            @Override
                            public void changed(ObservableValue ov, String t, String t1) {
                                for (IdentificacionIngresoDTO dto2 : colIdentificadorIngreso) {
                                    if (dto2.getIdentificador().equals(dto.getIdentificador().getIdentificador())) {
                                   ingresoIdentificadorCombo.setValue(dto.getIdentificador().getIdentificador());  
}
                                }
                            }
                        });

                        ingresoNombreText.setVisible(true);
                        ingresoValorText.setVisible(true);
                        ingresoDescripArea.setVisible(true);
                        String nuevoFormatoInicio = new SimpleDateFormat(formatoFX).format(dto.getFechaInicio());
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate nuevaFechaInicio = LocalDate.parse(nuevoFormatoInicio, formato);
                        ingresoFechaIniDate.setValue(nuevaFechaInicio);
                        if (dto.getFechaFin() != null) {
                            String nuevoFormatoFin = new SimpleDateFormat(formatoFX).format(dto.getFechaFin());
                            LocalDate nuevaFechaFin = LocalDate.parse(nuevoFormatoFin, formato);
                            ingresoFechaFinDate.setValue(nuevaFechaFin);
                        } else {
                            ingresoFechaFinDate.setValue(null);
                        }
                        ingresoFechaIniDate.setVisible(true);
                        ingresoFechaFinDate.setVisible(true);
                        ingresoIdentificadorLabel.setVisible(true);
                        ingresoNombreLabel.setVisible(true);
                        ingresoValorLabel.setVisible(true);
                        ingresoDescripLabel.setVisible(true);
                        ingresoFechaIniLabel.setVisible(true);
                        ingresoFechaFinLabel.setVisible(true);
                        ingresoCrear.setVisible(true);

                    }
                }
            }
        });

    }

    @FXML
    private void formularioEliminarIngreso(ActionEvent event) throws IOException {
        System.out.println("Mostrar formulario para crear un ingresos...!");
        ingresoHeadLabel.setText("Crear un ingreso");
        ingresoNombreText.setText("");
        ingresoValorText.setText("");
        ingresoDescripArea.setText("");
        ingresoFechaIniDate.setValue(null);
        ingresoFechaFinDate.setValue(null);
        ingresoFechaIniDate.setVisible(true);
        ingresoFechaFinDate.setVisible(true);
        ingresoIdentificadorLabel.setVisible(true);
        ingresoNombreLabel.setVisible(true);
        ingresoValorLabel.setVisible(true);
        ingresoDescripLabel.setVisible(true);
        ingresoFechaIniLabel.setVisible(true);
        ingresoFechaFinLabel.setVisible(true);
        ingresoCrear.setVisible(true);

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
        Stage stage = (Stage) buscarIdentificadorIngreso.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void crearIdentificadorIngreso() throws Exception {
        int crear = facade.insertarIdentificadoresIngresosActivo(input_identificador_IdentificadorIngreso.getText(), area_descripcion_IdentificadorIngreso.getText());
        if (crear == 1) {
            input_identificador_IdentificadorIngreso.setText("");
            area_descripcion_IdentificadorIngreso.setText("");
            System.out.println("Ha sido creado exitosamente");
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/RegistroExitoso.fxml"));
            Stage stage = new Stage();
            Scene scene;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Satisfactorio");
            stage.show();
            stage.setResizable(false);
            colIdentificadorIngreso = facade.obtenerIdentificacionIngresosActivo();
            buscarIdentificadorIngreso.getItems().clear();
            for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
                buscarIdentificadorIngreso.getItems().addAll(dto.getIdentificador());
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
    private void modificarIdentificadorIngreso() throws Exception {
        int modificar = facade.modificarIdentificadoresIngresosActivo(id_facade, input_identificador_IdentificadorIngreso.getText(), area_descripcion_IdentificadorIngreso.getText());
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
            colIdentificadorIngreso = facade.obtenerIdentificacionIngresosActivo();
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
        } else {
            input_identificador_IdentificadorIngreso.setText("");
            area_descripcion_IdentificadorIngreso.setText("");
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
    private void eliminarIdentificadorIngreso() throws Exception {
        int eliminar = facade.eliminarIdentificadoresIngresosActivo(id_facade);
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
            colIdentificadorIngreso = facade.obtenerIdentificacionIngresosActivo();
            buscarIdentificadorIngreso.getItems().clear();
            for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
                buscarIdentificadorIngreso.getItems().addAll(dto.getIdentificador());
            }
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
        } else {
            input_identificador_IdentificadorIngreso.setText("");
            area_descripcion_IdentificadorIngreso.setText("");
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
        for (IdentificacionIngresoDTO dto : colIdentificadorIngreso) {
            buscarIdentificadorIngreso.getItems().addAll(dto.getIdentificador());
        }
        buscarIdentificadorIngreso.setEditable(true);
        for (IngresoDTO dto : colIngreso) {
            buscarIngreso.getItems().addAll(dto.getNombre());
        }
        buscarIngreso.setEditable(true);
        for (IdentificacionEgresoDTO dto : colIdentificadorEgreso) {
            buscarIdentificadorEgreso.getItems().addAll(dto.getIdentificador());
        }
        buscarIdentificadorEgreso.setEditable(true);
        for (IdentificacionIngresoDTO dto2 : colIdentificadorIngreso) {
            ingresoIdentificadorCombo.getItems().addAll(dto2.getIdentificador());
        }
        ingresoIdentificadorCombo.setEditable(true);
    }

}
