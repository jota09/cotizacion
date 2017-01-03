/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizacion;

/**
 *
 * @author root
 */
public class Usuario {
    private String user;
    private boolean validoUser;
    private String pass;
    private boolean validoPass;
    private String name;
    
    public Usuario(){
        user = null;
        pass = null;
        name = null;
        validoUser=false;
        validoPass=false;
    }
    public Usuario(String user, String pass, String name){
        this.user = user;
        this.pass = pass;
        this.name = name;
    }
    
    public String getUser(){
        return user;
    }
    public boolean getValidoUser(){
        return validoUser;
    }
    public String getPass(){
        return pass;
    }
    public boolean getValidoPass(){
        return validoPass;
    }
    public String getName(){
        return name;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setValidoUser(boolean validoUser){
        this.validoUser = validoUser;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public void setValidoPass(boolean validoPass){
        this.validoPass = validoPass;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return "Usuario: "+user+", Contraseña: "+pass+", Nombre: "+name+", Valido Usuario: "+validoUser+", Valido Password: "+validoPass;
    }
    
}
