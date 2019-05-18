package controlador;

import controlador.ejemplo.EjemploCTR;
import java.io.File;
import modelo.Constantes;
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

        File pv = new File("Ditool.jar");
        if (pv.exists()) {
            Constantes.ejecutarJAR("Ditool");
        } else {
            System.out.println("No tenemos el versionador instalado.");
            VtnPrincipal vtnPrin = new VtnPrincipal();
            BienvenidaPnl pnlBienvenida = new BienvenidaPnl();
            NvPnl pnlNv = new NvPnl();

            EjemploCTR ejem = new EjemploCTR(pnlBienvenida, vtnPrin, pnlNv);
            ejem.iniciar();
        }
    }

    public static void estiloWindows() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("No tiene instalado windows: " + ex.getMessage());
        }
    }
}
