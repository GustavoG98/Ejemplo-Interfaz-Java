package controlador.estilo;

import javax.swing.JTable;
import modelo.estilo.TblEstilo;

/**
 *
 * @author Johnny
 */
public class TblCTR {

    public static void estiloTbl(JTable tbl) {
        TblEstilo.letrasTbl(tbl);
        TblEstilo.ocualtarID(tbl);
        TblEstilo.titutloTbl(tbl);
    }

}
