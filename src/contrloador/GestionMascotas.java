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

import modelo.Mascota;


public class GestionMascotas {
     public ArrayList<Mascota> getListMascota(){
        //Telefono tel=new Telefono();
    ArrayList<Mascota> os=new ArrayList<>();
        try {
            Connection ctx=Conexion.getConnection();
            Statement st=ctx.createStatement();
            ResultSet rs=st.executeQuery("SELECT *"
                    + " FROM VET_ANIMALES ");
            while(rs.next()){
            Mascota mas=new Mascota();
            mas.setId(rs.getInt("ANI_ID"));
            mas.setNombre(rs.getString("ANI_NOMBRE").trim());
            mas.setEdad(rs.getInt("ANI_EDAD"));
           mas.setDueno(rs.getString("VET_CLIENTES_CLI_ID"));
           mas.setRaza(rs.getString("VET_RAZAS_RAZ_ID"));
            System.out.println("Entro"); 
            os.add(mas);
                
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             
            System.out.println("Error en Listado");
        }
    return os;
    }
    
     public void InsertMascota(Mascota mascota) {
         
    
        try {
            Connection cnx= Conexion.getConnection();
           PreparedStatement pst=cnx.prepareStatement("INSERT INTO VET_ANIMALES (ANI_ID,"
                   + " ANI_NOMBRE, ANI_EDAD,VET_CLIENTES_CLI_ID,VET_RAZAS_RAZ_ID )"
                    + " VALUES(?,?,?,?,?,?)"); 
           pst.setInt(1,mascota.getId());
           pst.setString(2,mascota.getNombre());
           pst.setInt(3,mascota.getEdad());
           pst.setString(4, mascota.getDueno());
           pst.setString(5, mascota.getRaza());
           /*
           pst.setString(4,mascota.get());
           pst.setString(5, mascota.getTelefonos().getNumero());
           pst.setString(6,mascota.getCorreo());*/
          
          
           pst.executeQuery();
            
        }
            
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
  }
}
     public Mascota getBuscarMascota(String codMas){
    Mascota ma=null;
       try {
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "   FROM VET_ANIMALES WHERE = '"+codMas+"'");
            while (rs.next()) {
             ma=new Mascota();
             ma.setId(rs.getInt("ANI_ID"));
             ma.setNombre(rs.getString("ANI_NOMBRE"));
             ma.setEdad(rs.getInt("ANI_EDAD"));
             
            
            }
        } catch (SQLException  e ) {
            e.printStackTrace();
            
            System.out.println(e.getMessage());
            
            System.out.println("Error en buscar");
           
        }
    return ma;
    }
     
    
     
     
      public void ActualizarMascota(Mascota mascota){
        try{
            Connection cnx= Conexion.getConnection();
            PreparedStatement pst=cnx.prepareStatement(" UPDATE VET_ANIMALES SET "
            +"ANI_ID=?,ANI_NOMBRE=?,ANI_EDAD?,VET_CLIENTES_CLI_ID=?, VET_RAZAS_RAZ_ID=? WHERE ANI_NOMBRE='"+mascota.getNombre()+"'");//Consulta para actualizar la tabla de clientes
            pst.setInt(1, mascota.getId());
            pst.setString(2, mascota.getNombre());
            pst.setInt(3, mascota.getEdad());
           pst.setString(4, mascota.getDueno());
           pst.setString(5, mascota.getRaza());
           
           pst.executeQuery();// Manda a ejecutar la consulta
           
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
             System.out.println("Error en Actualizar Dato");
        }
    }
     
      
       public void EliminarMascota(String codNom){
        try{
            Connection cnx= Conexion.getConnection();
            PreparedStatement pst = cnx.prepareStatement("DELETE FROM VET_ANIMALES "
            +"WHERE ANI_ID=?");//Consulta para Eliminar cliente mediante el atributo cli_cedula
            pst.setString(1, codNom);
            pst.executeQuery(); // Manda a ejecutar la consulta
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en Eliminar Datos");
            
        }
    }
       
       
     
       
       
       
       
}
