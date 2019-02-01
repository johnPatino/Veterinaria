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
import modelo.Detalle_Factura;
import modelo.Factura;

/**
 *
 * @author Bernardo
 */
public class GestionFacturasDetalle {
    
     public ArrayList<Detalle_Factura> getListDetalleFactura(){
        
    ArrayList<Detalle_Factura> os=new ArrayList<>();
        try {
            Connection ctx=Conexion.getConnection();
            Statement st=ctx.createStatement();
            ResultSet rs=st.executeQuery("SELECT *"
                    + " FROM VET_FACTURAS_DETALLE");
            while(rs.next()){
          Detalle_Factura fac =new Detalle_Factura();
            
            
            fac.setDet_id(rs.getInt("DET_FAC_ID"));
              fac.setValor_total(rs.getDouble("DET_FAC_SUBTOTAL"));
             fac.setValor_unitario(rs.getDouble("DET_FAC_VALORVENTA"));
             fac.setPro_id(rs.getInt("VET_PRODUCTOS_PRO_ID"));
             fac.setFac_id(rs.getInt("VET_FACTURAS_CABECERA_FAC_ID"));
             fac.setKar_id(rs.getInt("VET_KARDEX_KAR_ID"));
             fac.setCantidad(rs.getInt("DET_CANTIDAD"));
            
            
            os.add(fac);
               
            }
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             
            System.out.println("Error en Listado");
        }
    return os;
    }
     
     
     public void InsertaFacturaDetalle(Detalle_Factura detfac) {
         
    
        try {
            Connection cnx= Conexion.getConnection();
           PreparedStatement pst=cnx.prepareStatement("INSERT INTO VET_FACTURAS_DETALLE (DET_FAC_ID,"
                   + " DET_FAC_SUBTOTAL, DET_FAC_VALORVENTA,VET_PRODUCTOS_PRO_ID ,VET_FACTURAS_CABECERA_FAC_ID,VET_KARDEX_KAR_ID,DET_CANTIDAD )"
                    + " VALUES(?,?,?,?,?,?,?)"); 
           pst.setInt(1,detfac.getDet_id());
           pst.setDouble(2,detfac.getValor_total());
           pst.setDouble(3,detfac.getValor_unitario());
           pst.setInt(4,detfac.getPro_id());
           pst.setInt(5,detfac.getFac_id());
             pst.setInt(6,detfac.getKar_id());
             pst.setInt(7,detfac.getCantidad() );
        
          
          
          
           pst.executeQuery();
            
        }
            
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en Ingresar datos");
  }
}
    
}
