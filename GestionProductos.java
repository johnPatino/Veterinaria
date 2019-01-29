/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrloador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public ArrayList<Producto> getListProducto(){
        //Producto pro=new Producto();
    ArrayList<Producto> prod=new ArrayList<>();
        try {
            Connection ctx=Conexion.getConnection();
            Statement st=ctx.createStatement();
            ResultSet rs=st.executeQuery("SELECT *"
                    + " FROM VET_PRODUCTOS ");
            while(rs.next()){
            Producto pro=new Producto();
            pro.setPro_id(rs.getInt("PRO_ID"));
            pro.setNombre(rs.getString("PRO_NOMBRE").trim());
            pro.setTipo(rs.getString("PRO_TIPO").trim());
            pro.setNacionalidad(rs.getString("PRO_NACIONALIDAD").trim());
            pro.setStock(rs.getInt("PRO_STOCK"));
            
           
            prod.add(pro);
               
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             
            System.out.println("Error en Listado");
        }
    return prod;
}
}

