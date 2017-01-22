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
public class UsuarioDTO {
    private int id;
    private String user;
    private String nombre;
    private String pass;
    private int meta;
    private boolean activo;
    private boolean eliminado;
    private boolean validoUser;
    private boolean validoPass;
    
    public UsuarioDTO(){
    this.id = 0;
    this.user = "";
    this.nombre = "";
    this.pass = "";
    this.meta = 0;
    this.activo = true;
    this.eliminado = false;
    }
    
    public UsuarioDTO(int id, String user, String nombre, String pass, int meta, boolean activo, boolean eliminado){
    this.id = id;
    this.user = user;
    this.nombre = nombre;
    this.pass = pass;
    this.meta = meta;
    this.activo = activo;
    this.eliminado = eliminado;
    }
    
    public String toString(){
        return "Usuario: "+user+", Contraseña: "+pass+", Nombre: "+nombre+", Valido Usuario: "+validoUser+", Valido Password: "+validoPass;
    }
    
    public int getId(){
        return id;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getPass(){
        return pass;
    }
    
    public int getMeta(){
        return meta;
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
    
    public void setUser(String user){
        this.user = user;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    
    public void setElimnado(boolean eliminado){
        this.eliminado = eliminado;
    }

    public boolean getValidoUser(){
        return validoUser;
    }

    public boolean getValidoPass(){
        return validoPass;
    }

    public void setValidoUser(boolean validoUser){
        this.validoUser = validoUser;
    }

    public void setValidoPass(boolean validoPass){
        this.validoPass = validoPass;
    }
}
