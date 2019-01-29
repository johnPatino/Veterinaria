/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrloador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Producto;
/**
 *
 * @author john
 */

public class TablaProducto extends AbstractTableModel {
   
    public String[] columnas = { "Pro_id", "Pro_nombre", "Pro_tipo","pro_nacionalidad","Pro_stock" };

	public Class[] columnasTipos = { Integer.class, String.class, String.class,String.class,Integer.class };
	private List<Producto> datos;

	public TablaProducto() {
		super();
		datos = new ArrayList<Producto>();
	}

	public TablaProducto(List<Producto> datos) {
		super();
		this.datos = datos;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	public void setValueAt(Object value, int row, int col) {
		Producto dato = (Producto) (datos.get(row));

		switch (col) {
		case 0:
			dato.setPro_id((Integer) value);
			break;
		case 1:
			dato.setNombre((String) value);
			break;
		case 2:
			dato.setTipo((String) value);
			break;
                case 3:
			dato.setNacionalidad((String) value);
			break; 
                case 4:
			dato.setStock((Integer) value);
			break;
		default:
			break;
		}
	}

	public String getColumnName(int col) {
		return columnas[col];
	}

	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}

	public Object getValueAt(int row, int col) {
		Producto dato = (Producto) (datos.get(row));
		switch (col) {
		case 0:
			return dato.getPro_id();
		case 1:
			return dato.getNombre();
		case 2:
			return dato.getTipo();
                case 3:
			return dato.getNacionalidad();
                case 4:
			return dato.getStock();
		default:
			break;
		}
		return new String();
	}

}



    
