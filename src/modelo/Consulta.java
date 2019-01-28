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
public class Consulta {
    
    private Doctor nombre_doctor;
    private Cliente nombre;
    private Mascota nombremascota;
    int numero_consulta;
    double costo_consulta;

    
    public Cliente getNombre() {
        return nombre;
    }

    public void setNombre(Cliente nombre) {
        this.nombre = nombre;
    }

    public Mascota getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(Mascota nombremascota) {
        this.nombremascota = nombremascota;
    }

    public Consulta(Doctor nombre_doctor, Cliente nombre, Mascota nombremascota, int numero_consulta, double costo_consulta) {
        this.nombre_doctor = nombre_doctor;
        this.nombre = nombre;
        this.nombremascota = nombremascota;
        this.numero_consulta = numero_consulta;
        this.costo_consulta = costo_consulta;
    }
   
     public Consulta() {
        
    }
 

    public Doctor getNombre_doctor() {
        return nombre_doctor;
    }

    public void setNombre_doctor(Doctor nombre_doctor) {
        this.nombre_doctor = nombre_doctor;
    }

    public int getNumero_consulta() {
        return numero_consulta;
    }

    public void setNumero_consulta(int numero_consulta) {
        this.numero_consulta = numero_consulta;
    }

    public double getCosto_consulta() {
        return costo_consulta;
    }

    public void setCosto_consulta(double costo_consulta) {
        this.costo_consulta = costo_consulta;
    }
    
}
