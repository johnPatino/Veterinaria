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
import modelo.Telefono;
import modelo.Tipo_telefono;


/**
 *
 * @author Bernardo
 */
public class GestionClientes {
    public ArrayList<Cliente> getListCliente(){
       // Telefono tel=new Telefono();
    ArrayList<Cliente> us=new ArrayList<>();
        try {
            Connection ctx=Conexion.getConnection();
            Statement st=ctx.createStatement();
            ResultSet rs=st.executeQuery("SELECT *"
                    + " FROM VET_CLIENTES ");
            while(rs.next()){
            Cliente cli=new Cliente();
            cli.setId(rs.getInt("CLI_ID"));
            cli.setCedula(rs.getString("CLI_CEDULA").trim());
            cli.setNombre(rs.getString("CLI_NOMBRE").trim());
            cli.setDireccion(rs.getString("CLI_DIRECCION").trim());
            cli.setTelefono(rs.getString("CLI_TELEFONO").trim());
            
            us.add(cli);
               
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             
            System.out.println("Error en Listado");
        }
    return us;
    }
    
     public void InsertCliente(Cliente cliente) {
         
    
        try {
            Connection cnx= Conexion.getConnection();
           PreparedStatement pst=cnx.prepareStatement("INSERT INTO VET_CLIENTES (CLI_ID,"
                   + " CLI_CEDULA, CLI_NOMBRE,CLI_DIRECCION,CLI_TELEFONO, CLI_EMAIL )"
                    + " VALUES(?,?,?,?,?,?)"); 
           pst.setInt(1,cliente.getId());
           pst.setString(2,cliente.getCedula());
           pst.setString(3,cliente.getNombre());
           pst.setString(4,cliente.getDireccion());
           pst.setString(5, cliente.getTelefono());
           pst.setString(6,cliente.getCorreo());
          
          
           pst.executeQuery();
            
        }
            
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
  }
}
    public Cliente getBuscarCliente(String codCli){
    Cliente cl=null;
       try {
            Connection cnx = Conexion.getConnection();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "   FROM VET_CLIENTES WHERE cli_cedula= '"+codCli+"'");
            while (rs.next()) {
             cl=new Cliente();
             cl.setId(rs.getInt("CLI_ID"));
             cl.setCedula(rs.getString("CLI_CEDULA"));
             cl.setNombre(rs.getString("CLI_NOMBRE"));
             cl.setDireccion(rs.getString("CLI_DIRECCION"));
             cl.setTelefono(rs.getString("CLI_TELEFONO"));
             cl.setCorreo(rs.getString("CLI_EMAIL"));
            
            }
        } catch (SQLException  e ) {
            e.printStackTrace();
            
            System.out.println(e.getMessage());
            
            System.out.println("Error en buscar");
        }
    return cl;
    }
    
    public void ActualizarCliente(Cliente cliente){
        try{
            Connection cnx= Conexion.getConnection();
            PreparedStatement pst=cnx.prepareStatement(" UPDATE VET_CLIENTES SET"
            +"CLI_ID=?,CLI_CEDULA=?,CLI_NOMBRE=?,CLI_DIRECCION=?,CLI_TELEFONO=?,CLI_EMAIL=? WHERE CLI_ID='"+cliente.getId()+"'");
            pst.setInt(1, cliente.getId());
            pst.setString(2, cliente.getCedula());
            pst.setString(3,cliente.getNombre());
           pst.setString(4, cliente.getDireccion());
           pst.setString(5, cliente.getTelefono());
           pst.setString(6, cliente.getCorreo());
           pst.executeQuery();
           
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
             System.out.println("Error en Actualizar Dato");
        }
    }
    
    public void EliminarCliente(String cedula){
        try{
            Connection cnx= Conexion.getConnection();
            PreparedStatement pst = cnx.prepareStatement("DELETE FROM VET_CLIENTES"
            +"WHERE CLI_CEDULA=?");
            pst.setString(1, cedula);
            pst.executeQuery();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en Eliminar Datos");
            
        }
    }
}
