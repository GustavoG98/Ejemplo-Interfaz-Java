package controlador.estilo;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.estilo.TblEstilo;
import modelo.estilo.TblRenderLblIcono;

/**
 *
 * @author Johnny
 */
public class TblCTR {

    public static void estiloTbl(JTable tbl) {
        TblEstilo.letrasTbl(tbl);
        TblEstilo.titutloTbl(tbl);
    }

    public static void estiloTblConIcono(JTable tbl) {
        //Pasamos el estilo normal de nuestra tbl
        estiloTbl(tbl);

        //Consultamos la ultima columna de la tabla
        int ultColumna = tbl.getColumnCount() - 1;
        //La ultima columna le pasamos un ancho de 30px 
        tbl.getColumnModel().getColumn(ultColumna).setMaxWidth(30);
        tbl.getColumnModel().getColumn(ultColumna).setMinWidth(30);
        tbl.getColumnModel().getColumn(ultColumna).setPreferredWidth(30);
        //Le pasamos sun render para que agrege el icono de mas 
        tbl.getColumnModel().getColumn(ultColumna).setCellRenderer(new TblRenderLblIcono(ultColumna));
    }

    public static void estiloTblSinID(JTable tbl) {
        TblEstilo.letrasTbl(tbl);
        TblEstilo.ocualtarID(tbl);
        TblEstilo.titutloTbl(tbl);
    }

    public static DefaultTableModel modeloTablaSinEditar(String datos[][], String titulo[]) {
        DefaultTableModel modelo = new DefaultTableModel(datos, titulo){
            @Override
            public final boolean isCellEditable(int row, int column){
                return false;
            }
        };
        return modelo;
    }

}
