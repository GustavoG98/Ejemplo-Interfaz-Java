package modelo.estilo;

import javax.swing.JButton;

/**
 *
 * @author Johnny
 */
public class BtnClick {
    
    public static void btnSeleccionado(JButton btn){
        btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    }
    
    public static void btnDeseleccionado(JButton btn){
        btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 79, 117)));
    }
}
