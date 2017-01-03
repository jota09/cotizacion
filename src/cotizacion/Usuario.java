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
    private String pass;
    private String name;
    
    public Usuario(){
        user = null;
        pass = null;
        name = null;
    }
    public Usuario(String user, String pass, String name){
        this.user = user;
        this.pass = pass;
        this.name = name;
    }
    
    public String getUser(){
        return user;
    }
    public String getPass(){
        return user;
    }
    public String getName(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public void setName(String name){
        this.name = name;
    }
    
}
