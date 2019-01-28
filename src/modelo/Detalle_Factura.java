/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Bernardo
 */
public class Detalle_Factura {
    
    
    private int cantidad;
    private String descirpcion,firma_cliente;
    private double valor_unitario ,valor_total, valor_a_pagar,valor_consulta;

    public Detalle_Factura(int cantidad, String descirpcion, String firma_cliente, double valor_unitario, double valor_total, double valor_a_pagar, double valor_consulta) {
        this.cantidad = cantidad;
        this.descirpcion = descirpcion;
        this.firma_cliente = firma_cliente;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
        this.valor_a_pagar = valor_a_pagar;
        this.valor_consulta = valor_consulta;
    }
    
    public Detalle_Factura() {
        
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescirpcion() {
        return descirpcion;
    }

    public void setDescirpcion(String descirpcion) {
        this.descirpcion = descirpcion;
    }

    public String getFirma_cliente() {
        return firma_cliente;
    }

    public void setFirma_cliente(String firma_cliente) {
        this.firma_cliente = firma_cliente;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getValor_a_pagar() {
        return valor_a_pagar;
    }

    public void setValor_a_pagar(double valor_a_pagar) {
        this.valor_a_pagar = valor_a_pagar;
    }

    public double getValor_consulta() {
        return valor_consulta;
    }

    public void setValor_consulta(double valor_consulta) {
        this.valor_consulta = valor_consulta;
    }
   
  
    
}
