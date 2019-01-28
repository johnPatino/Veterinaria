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
   /* public ArrayList<Cliente> getListUsuario(){
        Telefono tel=new Telefono();
    ArrayList<Cliente> us=new ArrayList<>();
        try {
            Connection ctx=Conexion.getConnection();
            Statement st=ctx.createStatement();
            ResultSet rs=st.executeQuery("SELECT *"
                    + " FROM usuarios ");
            while(rs.next()){
            Cliente cli=new Cliente();
            cli.setId(rs.getInt("CLI_ID"));
            cli.setCedula(rs.getString("CLI_CEDULA").trim());
            cli.setNombre(rs.getString("CLI_NOMBRE").trim());
            cli.setDireccion(rs.getString("CLI_DIRECCION").trim());
            cli.setTelefonos(tel.setNumero(rs.getInt("CLI_TELEFONO")));
            
            us.add(usu);
               
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             
            System.out.println("Error en Listado");
        }
    return us;
    }*/
    
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
           pst.setString(5, cliente.getTelefonos().getNumero());
           pst.setString(6,cliente.getCorreo());
          
          
           pst.executeQuery();
            
        }
            
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
  }
}
    
}
