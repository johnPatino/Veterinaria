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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Personal;
import modelo.Telefono;

/**
 *
 * @author Bernardo
 */
public class GestionEmpleados {
   
    public ArrayList<Personal> getListEmpleado(){
        
    ArrayList<Personal> os=new ArrayList<>();
        try {
            Connection ctx=Conexion.getConnection();
            Statement st=ctx.createStatement();
            ResultSet rs=st.executeQuery("SELECT *"
                    + " FROM VET_EMPLEADOS ");
            while(rs.next()){
            Personal  emp =new Personal();
            emp.setId(rs.getInt("EMP_ID"));
            emp.setCedula(rs.getString("EMP_CEDULA").trim());
            emp.setNombre(rs.getString("EMP_NOMBRE").trim());
            emp.setUsuario(rs.getString("EMP_USUARIO").trim());
            emp.setRol(rs.getString("EMP_ROLL").trim());
            emp.setContrasena(rs.getString("EMP_CONTRASENA").trim());
            emp.setEdad(rs.getInt("EMP_EDAD"));
            emp.setDireccion(rs.getString("EMP_DIRECCION").trim());
            
            
            os.add(emp);
               
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             
            System.out.println("Error en Listado");
        }
    return os;
    }
    
     public void Insertarempleados(Personal personal) {
         
    
        try {
            Connection cnx= Conexion.getConnection();
           PreparedStatement pst=cnx.prepareStatement("INSERT INTO VET_EMPLEADOS (EMP_ID,"
                   + " EMP_CEDULA, EMP_NOMBRE,EMP_USUARIO,EMP_ROLL,EMP_CONTRASENA,EMP_EDAD,EMP_DIRECCION,EMP_TELEFONO )"
                    + " VALUES(?,?,?,?,?,?,?,?,?)"); 
           pst.setInt(1,personal.getId());
           pst.setString(2,personal.getCedula());
           pst.setString(3,personal.getNombre());
           pst.setString(4,personal.getUsuario());
           pst.setString(5,personal.getRol());
           pst.setString(6,personal.getContrasena());
           pst.setInt(7,personal.getEdad());
           pst.setString(8,personal.getDireccion());
           pst.setString(9, personal.getTelefonos());
          
          
          
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
     
     public Personal getBuscarEmpleado(String codemp){
      Personal cl=null;
       try {
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "   FROM VET_EMPLEADOS WHERE EMP_CEDULA= '"+codemp+"'");
            while (rs.next()) {
             cl=new Personal();
             cl.setId(rs.getInt("EMP_ID"));
              cl.setCedula(rs.getString("EMP_CEDULA"));
              cl.setNombre(rs.getString("EMP_NOMBRE"));
             cl.setUsuario(rs.getString("EMP_USUARIO"));
             cl.setRol(rs.getString("EMP_ROLL"));
             cl.setContrasena(rs.getString("EMP_CONTRASENA"));
             cl.setEdad(rs.getInt("EMP_EDAD"));
             cl.setDireccion(rs.getString("EMP_DIRECCION"));
             cl.setTelefonos(rs.getString("EMP_TELEFONO"));
            
            }
        } catch (SQLException  e ) {
            e.printStackTrace();
            
            System.out.println(e.getMessage());
            
            System.out.println("Error en buscar");
        }
    return cl;
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
