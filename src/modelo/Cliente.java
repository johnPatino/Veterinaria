/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Bernardo
 */
public class Cliente  extends Persona{
    private int id;
    private String correo ;
    private Mascota nombremascota;

    public Cliente(String correo, Mascota nombremascota) {
        this.correo = correo;
        this.nombremascota = nombremascota;
    }
     public Cliente() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
        
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Mascota getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(Mascota nombremascota) {
        this.nombremascota = nombremascota;
    }

   
}
