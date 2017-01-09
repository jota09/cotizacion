/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EgresoDAO;
import dao.IngresoDAO;
import dto.IngresoDTO;
import dto.EgresoDTO;
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
    
}
