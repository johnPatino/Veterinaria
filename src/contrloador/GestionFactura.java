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
import modelo.Factura;
import modelo.Personal;

/**
 *
 * @author Bernardo
 */
public class GestionFactura {
    public ArrayList<Factura> getListFactura(){
        
    ArrayList<Factura> os=new ArrayList<>();
        try {
            Connection ctx=Conexion.getConnection();
            Statement st=ctx.createStatement();
            ResultSet rs=st.executeQuery("SELECT *"
                    + " FROM VET_FACTURAS_CABECERA");
            while(rs.next()){
          Factura fac =new Factura();
            
            
            fac.setFac_id(rs.getInt("FAC_ID"));
              fac.setTotal(rs.getDouble("FAC_VALOR_TOTAL"));
             fac.setSubtotal(rs.getDouble("FAC_VALOR_SUBTOTAL"));
             fac.setCliente_id(rs.getInt("VET_CLIENTES_CLI_ID"));
             fac.setFecha(rs.getString("FAC_FECHA").trim());
            
            
            os.add(fac);
               
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             
            System.out.println("Error en Listado");
        }
    return os;
    }
    
     public void InsertaFactura(Factura fac) {
         
    
        try {
            Connection cnx= Conexion.getConnection();
           PreparedStatement pst=cnx.prepareStatement("INSERT INTO VET_FACTURAS_CABECERA (FAC_ID,"
                   + " FAC_VALOR_TOTAL, FAC_VALOR_SUBTOTAL,VET_CLIENTES_CLI_ID,FAC_FECHA )"
                    + " VALUES(?,?,?,?,?)"); 
           pst.setInt(1,fac.getFac_id());
           pst.setDouble(2,fac.getTotal());
           pst.setDouble(3,fac.getSubtotal());
           pst.setInt(4,fac.getCliente_id());
           pst.setString(5,fac.getFecha());
        
          
          
          
           pst.executeQuery();
            
        }
            
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
  }
}
     
      public void ActualizarEmpleado(Personal personal){
        try {
            Connection cnx = Conexion.getConnection();
            PreparedStatement pst = cnx.prepareStatement(" UPDATE VET_EMPLEADOS SET "
                    + " EMP_ID=?,EMP_CEDULA=?,EMP_NOMBRE=?,EMP_USUARIO=?,EMP_ROLL=?,EMP_CONTRASENA=?, EMP_EDAD=?, EMP_DIRECCION=?, EMP_TELEFONO=? WHERE EMP_CEDULA= '"+personal.getCedula()+"'");
            pst.setInt(1, personal.getId());
            pst.setString(2, personal.getCedula());
            pst.setString(3, personal.getNombre());
            pst.setString(4,personal.getUsuario());
            pst.setString(5,personal.getRol());
            pst.setString(6,personal.getContrasena());
            pst.setInt(7,personal.getEdad());
            pst.setString(8,personal.getDireccion());
            pst.setString(9,personal.getTelefonos());
            pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
        }
     }
     
     public Factura getBuscarFactura(int codemp){
         Factura fac=null;
       try {
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
             + "   FROM VET_FACTURAS_CABECERA WHERE VET_CLIENTES_CLI_ID = '"+codemp+"'");
            while (rs.next()) {
             fac= new Factura();
             fac.setFac_id(rs.getInt("FAC_ID"));
              fac.setTotal(rs.getDouble("FAC_VALOR_TOTAL"));
             fac.setSubtotal(rs.getDouble("FAC_VALOR_SUBTOTAL"));
             fac.setCliente_id(rs.getInt("VET_CLIENTES_CLI_ID"));
             fac.setFecha(rs.getString("FAC_FECHA").trim());
             
            
            }
        } catch (SQLException  e ) {
            e.printStackTrace();
            
            System.out.println(e.getMessage());
            
            System.out.println("Error en buscar");
        }
    return fac;
    }
     
     public void EliminarEmpleado(String cedula){
        try {
            Connection cnx = Conexion.getConnection();
            PreparedStatement pst = cnx.prepareStatement("DELETE FROM VET_EMPLEADOS  "
                    + " WHERE EMP_CEDULA=?");
            pst.setString(1, cedula);
            pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Eliminar datos");
        }
     }
     
     
    
}
