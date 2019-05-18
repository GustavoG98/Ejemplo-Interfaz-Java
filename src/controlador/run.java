package controlador;

import javax.swing.JOptionPane;
import modelo.DitoolBD;
import modelo.Version;
import vista.VtnDitool;

/**
 *
 * @author Johnny
 */
public class run {

    public static void main(String[] args) {
        estiloWindows();

        VtnDitool vtnDitool = new VtnDitool();
        vtnDitool.setTitle("Ditool | Version instalada: ");
        DitoolBD conecta = new DitoolBD("VERSION", "AZUL");

        Version v = conecta.consultarUltimaVersion();

        if (v != null) {
            VtnDitoolCTR ctrVtn = new VtnDitoolCTR(v, vtnDitool);
            ctrVtn.iniciar();
        } else {
            JOptionPane.showMessageDialog(vtnDitool, "Posiblemente no tengamos acceso a internet. \n"
                    + "Verifique su conexion e intentelo de nuevo.");
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
