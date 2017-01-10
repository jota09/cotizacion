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
    
    public ArrayList<IngresoDTO> obtenerIngresosActivo(){
        IngresoDAO ingresoActivos = new IngresoDAO();
        return ingresoActivos.obtenerIngresosActivo();
    }
    
    public ArrayList<EgresoDTO> obtenerEgresosActivo(){
        EgresoDAO egresoActivos = new EgresoDAO();
        return egresoActivos.obtenerEgresosActivo();
    }
    
    public ArrayList<IdentificacionIngresoDTO> obtenerIdentificacionIngresosActivo(){
        IdentificacionIngresoDAO identificadoresIngresoActivos = new IdentificacionIngresoDAO();
        return identificadoresIngresoActivos.obtenerIdentificadoresIngresosActivo();
    }
    
    public ArrayList<IdentificacionEgresoDTO> obtenerIdentificacionEgresosActivo(){
        IdentificacionEgresoDAO identificadoresEgresoActivos = new IdentificacionEgresoDAO();
        return identificadoresEgresoActivos.obtenerIdentificadoresEgresosActivo();
    }
    
}
