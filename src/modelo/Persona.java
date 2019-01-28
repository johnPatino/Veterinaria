/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Bernardo
 */
public class Persona {
    private  String nombre,apellido,cedula,direccion;
    
    private Telefono telefonos;

    public Telefono getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Telefono telefonos) {
        this.telefonos = telefonos;
    }

   /* public Persona() {
      List<Telefono>telefonos=new ArrayList<>();
        
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   /* public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }*/
    
    
   
}
