/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 *
 * @author Jesus
 */
public class EgresoDTO {

    private int id;
    private String identificador;
    private String nombre;
    private int valor;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private boolean activo;
    private boolean eliminado;
    DecimalFormat formateador = new DecimalFormat("###,###.##");

    public EgresoDTO() {
        this.id = 0;
        this.identificador = null;
        this.nombre = null;
        this.descripcion = null;
        this.fecha_inicio = null;
        this.fecha_fin = null;
        this.activo = false;
        this.eliminado = true;
    }

    public EgresoDTO(int id, String identificador, String nombre, int valor, String descripcion, Date fecha_inicio, Date fecha_fin, boolean activo, boolean eliminado) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.activo = activo;
        this.eliminado = eliminado;
    }
    
    @Override
    public String toString(){
        return nombre+"(" +identificador+") "+formateador.format(valor)+"$";
    }

    public int getId() {
        return id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getValor(){
        return valor;
    }
    
    public String getDescripcion(){
        return descripcion;
    }

    public Date getFechaInicio() {
        return fecha_inicio;
    }

    public Date getFechaFin() {
        return fecha_fin;
    }

    public boolean getActivo() {
        return activo;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setFechaInicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFechaFin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}
