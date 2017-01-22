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
public class IdentificacionIngresoDTO {
    private int id;
    private String identificador;
    private String descripcion;
    private boolean activo;
    private boolean eliminado;
    private int usuario_id;
    
    public IdentificacionIngresoDTO(){
        id = 0;
        identificador = null;
        descripcion = null;
        activo = true;
        eliminado = false; 
        usuario_id = 0;
    }
    
    public IdentificacionIngresoDTO(int id, String identificador, String descipcion, boolean activo, boolean eliminado, int usuario_id){
        this.id = id;
        this.identificador = identificador;
        this.descripcion = descipcion;
        this.activo = activo;
        this.eliminado = eliminado;
        this.usuario_id = usuario_id;
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
    
    public int getUsuarioId(){
        return usuario_id;
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
    
    public void setUsuarioId(int usuario_id){
        this.usuario_id = usuario_id;
    }
}
