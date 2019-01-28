/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;


/**
 *
 * @author Bernardo
 */
public class Factura {
   private Date fecha;
    private Cliente nombre , direccion , correo, telefono ,cedula;
    private Detalle_Factura detalle;

    public Factura(Date fecha, Cliente nombre, Cliente direccion, Cliente correo, Cliente telefono, Cliente cedula, Detalle_Factura detalle) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.detalle = detalle;
    }
    
     public Factura() {
        
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getNombre() {
        return nombre;
    }

    public void setNombre(Cliente nombre) {
        this.nombre = nombre;
    }

    public Cliente getDireccion() {
        return direccion;
    }

    public void setDireccion(Cliente direccion) {
        this.direccion = direccion;
    }

    public Cliente getCorreo() {
        return correo;
    }

    public void setCorreo(Cliente correo) {
        this.correo = correo;
    }

    public Cliente getTelefono() {
        return telefono;
    }

    public void setTelefono(Cliente telefono) {
        this.telefono = telefono;
    }

    public Cliente getCedula() {
        return cedula;
    }

    public void setCedula(Cliente cedula) {
        this.cedula = cedula;
    }

    public Detalle_Factura getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle_Factura detalle) {
        this.detalle = detalle;
    }
    
    
    
}
