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
public class Telefono {
    private int id,emp_id;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String tipo;
    private String numero;

   /* public Telefono(Tipo_telefono tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }*/

   /* public Tipo_telefono getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_telefono tipo) {
        this.tipo = tipo;
    }*/

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
   
    
}
