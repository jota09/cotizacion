/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EgresoDAO;
import dao.IdentificacionEgresoDAO;
import dao.IdentificacionIngresoDAO;
import dao.IngresoDAO;
import dto.IngresoDTO;
import dto.EgresoDTO;
import dto.IdentificacionEgresoDTO;
import dto.IdentificacionIngresoDTO;
import java.util.ArrayList;

/**
 *
 * @author Jesus
 */
public class Facade {

    public ArrayList<IngresoDTO> obtenerIngresosActivo() {
        IngresoDAO ingresoActivos = new IngresoDAO();
        return ingresoActivos.obtenerIngresosActivo();
    }

    public ArrayList<EgresoDTO> obtenerEgresosActivo() {
        EgresoDAO egresoActivos = new EgresoDAO();
        return egresoActivos.obtenerEgresosActivo();
    }

    public ArrayList<IdentificacionIngresoDTO> obtenerIdentificacionIngresosActivo() {
        IdentificacionIngresoDAO identificadoresIngresoActivos = new IdentificacionIngresoDAO();
        return identificadoresIngresoActivos.obtenerIdentificadoresIngresosActivo();
    }

    public ArrayList<IdentificacionEgresoDTO> obtenerIdentificacionEgresosActivo() {
        IdentificacionEgresoDAO identificadoresEgresoActivos = new IdentificacionEgresoDAO();
        return identificadoresEgresoActivos.obtenerIdentificadoresEgresosActivo();
    }

    public int insertarIdentificadoresIngresosActivo(String identificador, String descripcion) {
        IdentificacionIngresoDAO identificadoresIngresoActivos = new IdentificacionIngresoDAO();
        return identificadoresIngresoActivos.insertarIdentificadoresIngresosActivo(identificador, descripcion);

    }
    
    public int modificarIdentificadoresIngresosActivo(int id, String identificador, String descripcion) {
        IdentificacionIngresoDAO identificadoresIngresoActivos = new IdentificacionIngresoDAO();
        return identificadoresIngresoActivos.modificarIdentificadoresIngresosActivo(id, identificador, descripcion);

    }
    
    public int eliminarIdentificadoresIngresosActivo(int id) {
        IdentificacionIngresoDAO identificadoresIngresoActivos = new IdentificacionIngresoDAO();
        return identificadoresIngresoActivos.eliminarIdentificadoresIngresosActivo(id);

    }
}
