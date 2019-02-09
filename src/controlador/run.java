package controlador;

import controlador.ejemplo.EjemploCTR;
import vista.BienvenidaPnl;
import vista.VtnPrincipal;
import vista.ejemplo.NvPnl;

/**
 *
 * @author Johnny
 */
public class run {

    public static void main(String[] args) {
        estiloWindows();
        
        VtnPrincipal vtnPrin = new VtnPrincipal(); 
        BienvenidaPnl pnlBienvenida = new BienvenidaPnl();
        NvPnl pnlNv = new NvPnl(); 
        
        EjemploCTR ejem = new EjemploCTR(pnlBienvenida, vtnPrin, pnlNv); 
        ejem.iniciar();
    }

    public static void estiloWindows() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
