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
    private UsuarioDTO usuario;
    
    public IdentificacionIngresoDTO(){
        id = 0;
        identificador = null;
        descripcion = null;
        activo = true;
        eliminado = false; 
        usuario = null;
    }

    public IdentificacionIngresoDTO(int id, String identificador) {
        this.id = id;
        this.identificador = identificador;
    }
    
    public IdentificacionIngresoDTO(int id, String identificador, String descipcion, boolean activo, boolean eliminado, UsuarioDTO usuario){
        this.id = id;
        this.identificador = identificador;
        this.descripcion = descipcion;
        this.activo = activo;
        this.eliminado = eliminado;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "IdentificacionIngresoDTO{" + "id=" + id + ", identificador=" + identificador + ", descripcion=" + descripcion + ", activo=" + activo + ", eliminado=" + eliminado + ", usuario=" + usuario + '}';
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
    
    public UsuarioDTO getUsuarioId(){
        return usuario;
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
    
    public void setUsuarioId(UsuarioDTO usuario){
        this.usuario = usuario;
    }
}
