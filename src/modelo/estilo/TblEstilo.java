package modelo.estilo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Johnny
 */
public class TblEstilo {

    //Con este metodo ocultamos la primera columna de la tabla
    public static void ocualtarID(JTable tbl) {
        TableColumnModel mdColum = tbl.getColumnModel();

        //Ocultamso la id 
        mdColum.getColumn(0).setPreferredWidth(0);
        mdColum.getColumn(0).setWidth(0);
        mdColum.getColumn(0).setMinWidth(0);
        mdColum.getColumn(0).setMaxWidth(0);
    }

    //Le agregamos color y centramoslos titulos de las tablas
    public static void titutloTbl(JTable tbl) {
        JTableHeader tblHead = tbl.getTableHeader();

        tblHead.setBackground(new Color(49, 79, 117));
        tblHead.setForeground(new Color(255, 255, 255));
        tblHead.setOpaque(false);
        tblHead.setFont(new Font("Arial", Font.PLAIN, 16));
        //Para que no se pueda reordenar las columnas 
        tblHead.setReorderingAllowed(false);
        //Para que no se pueda cambiar su longitud  
        tblHead.setResizingAllowed(false);

        //Centramos los titulos de las tablas 
        DefaultTableCellRenderer hedRender = (DefaultTableCellRenderer) tblHead.getDefaultRenderer();
        //Centramos los textos
        hedRender.setHorizontalAlignment(JLabel.CENTER);
        //Le pasamos el render a nuestro table head
        tblHead.setDefaultRenderer(hedRender);
        
        
    }

    //Modificamos la anchura y estilo de letras de una tabla
    public static void letrasTbl(JTable tbl) {
        tbl.setFont(new Font("Arial", Font.PLAIN, 14));
        tbl.setRowHeight(30);
    }
}
