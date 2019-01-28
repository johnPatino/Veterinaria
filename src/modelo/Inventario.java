/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Bernardo
 */
public class Inventario {
    private List<Producto>listaproductos;
    private List<Consulta>listaconsultas;

    public Inventario(List<Producto> listaproductos, List<Consulta> listaconsultas) {
        this.listaproductos = listaproductos;
        this.listaconsultas = listaconsultas;
    }
    
    public Inventario(){
    }

    public List<Producto> getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(List<Producto> listaproductos) {
        this.listaproductos = listaproductos;
    }

    public List<Consulta> getListaconsultas() {
        return listaconsultas;
    }

    public void setListaconsultas(List<Consulta> listaconsultas) {
        this.listaconsultas = listaconsultas;
    }
    
      
}
