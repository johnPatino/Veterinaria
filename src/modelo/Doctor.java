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
public class Doctor extends Personal{
   private int id;
    private String especialidad;

    public Doctor(String profesion, String cargo, String edad) {
        super(profesion, cargo, edad);
    }
     public Doctor() {
       
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
  
    
    
}
