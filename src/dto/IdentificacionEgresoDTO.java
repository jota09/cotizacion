/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Jesus
 */
public class IdentificacionEgresoDTO {
    private int id;
    private String identificador;
    private String descripcion;
    private boolean activo;
    private boolean eliminado;
    
    public IdentificacionEgresoDTO(){
        id = 0;
        identificador = null;
        descripcion = null;
        activo = true;
        eliminado = false;
    }
    
    public IdentificacionEgresoDTO(int id, String identificador, String descipcion, boolean activo, boolean eliminado){
        this.id = id;
        this.identificador = identificador;
        this.descripcion = descipcion;
        this.activo = activo;
        this.eliminado = eliminado;
    }
     
    @Override
    public String toString(){
        return identificador+" "+descripcion;
    }
    
    public int getId(){
        return id;
    }
    
    public String getIdentificador(){
        return identificador;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public boolean getActivo(){
        return activo;
    }
    
    public boolean getEliminado(){
        return eliminado;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    
    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }
}
