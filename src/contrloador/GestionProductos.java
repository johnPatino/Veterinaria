/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrloador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cliente;
import modelo.Producto;

/**
 *
 * @author user
 */
public class GestionProductos {
     public void InsertProductos(Producto producto) {
         
    
        try {
            Connection cnx= Conexion.getConnection();
           PreparedStatement pst=cnx.prepareStatement("INSERT INTO  VET_PRODUCTOS (PRO_ID,"
                   + "PRO_NOMBRE, PRO_TIPO,PRO_NACIONALIDAD,PRO_STOCK)"
                    + " VALUES(?,?,?,?,?)"); 
           pst.setInt(1,producto.getPro_id());
           pst.setString(2,producto.getNombre());
           pst.setString(3,producto.getTipo());
           pst.setString(4,producto.getNacionalidad());
           pst.setInt(5,producto.getStock());
         
          
          
           pst.executeQuery();
            
        }
            
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
  }
}
    
}


